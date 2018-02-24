package com.codwis.datastructure.rpc.serviceprovider;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称:
 * @Date: 2018/2/23
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 注意：严格遵守编码规范要求
 */
public class EchoServiceImpl implements EchoService{


	public String echo(String ping) {
		System.out.println(ping);
		return "i am very ok";
	}
}
