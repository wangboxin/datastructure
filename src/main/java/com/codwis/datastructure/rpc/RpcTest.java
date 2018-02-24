package com.codwis.datastructure.rpc;

import com.codwis.datastructure.rpc.serviceconsumer.RpcImporter;
import com.codwis.datastructure.rpc.serviceprovider.EchoService;
import com.codwis.datastructure.rpc.serviceprovider.EchoServiceImpl;
import com.codwis.datastructure.rpc.serviceprovider.RpcExporter;

import java.net.InetSocketAddress;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称:
 * @Date: 2018/2/23
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 注意：严格遵守编码规范要求
 */
public class RpcTest {

    /*static {

	}*/
	public static void main(String[] args) {

		new Thread(new Runnable() {
			public void run() {
				try{
					RpcExporter.exporter("localhost", 8088);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}).start();

		RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
		EchoService echo = importer.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8088));
		System.out.println(echo.echo("are you ok"));
	}
}
