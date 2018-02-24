package com.codwis.datastructure.dynamicproxy;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称:
 * @Date: 2018/2/24
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 注意：严格遵守编码规范要求
 */
public class SayImpl implements Say{

	public void sayHello(String words) {
		System.out.printf("hello dynamicproxy");
	}
}
