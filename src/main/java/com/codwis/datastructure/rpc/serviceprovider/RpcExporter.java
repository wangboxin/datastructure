package com.codwis.datastructure.rpc.serviceprovider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称:
 * @Date: 2018/2/23
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 注意：严格遵守编码规范要求
 */
public class RpcExporter {
	static Executor excutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void exporter(String hostName,int port)throws Exception{

		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(hostName,port));
       try{
       	  while (true)
		   excutor.execute(new ExporterTask(server.accept()));
	   }finally {
       	   server.close();
	   }
	}

	/**
	 * 拿到客户端的调用信息，反射去执行并获得结果，把结果进行序列化再通过socket返回给客户端
	 */
	private static class ExporterTask implements Runnable{
    Socket client = null;
     public ExporterTask(Socket client){
          this.client = client;
	 }
		public void run() {
			ObjectInputStream input = null;
			ObjectOutputStream output = null;

            try{
                input = new ObjectInputStream(client.getInputStream());
                String interfaceName = input.readUTF();
                Class<?> service = Class.forName(interfaceName);
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[])input.readObject();
                Object[] arguments = (Object[])input.readObject();
                Method method = service.getMethod(methodName,parameterTypes);
                Object result = method.invoke(service.newInstance(),arguments);
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
			}catch (Exception e){
                 e.printStackTrace();
			}finally {
              if(output!=null)
              	try{
              	   output.close();
				}catch (IOException e){
              	   e.printStackTrace();
				}

            	if(input!=null)
            		try{
              	     input.close();
					}catch (IOException e){
              	       e.printStackTrace();
					}
            	if(client!=null)
            		try{
              	      client.close();
					}catch (IOException e){
              	      e.printStackTrace();
					}
			}
		}
	}
}
