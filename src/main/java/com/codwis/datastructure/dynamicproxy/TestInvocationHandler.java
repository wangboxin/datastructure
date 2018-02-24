package com.codwis.datastructure.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称:
 * @Date: 2018/2/24
 * @Copyright: www.msxf.com Inc. All rights reserved.
 *
 * JDK动态代理是基于接口的代理，下面举例说明
 * 代理类：proxy，代理动作必须要基于一个proxy实例来执行
 * 代理执行类：实现InvocationHandler，案例中是TestInvocationHandler
 * 被代理类：基于接口的用户自己的方法，案例中是SayImpl
 *
 * public interface InvocationHandler {
 *  public Object invoke(Object proxy, Method method, Object[] args)
 *  throws Throwable;
 *  }
 *
 *  proxy：方法基于哪个proxy实例来执行
 *  method：执行proxy实例的哪个方法（proxy代理谁就执行谁的方法）
 *  args：methed的入参
 *
 * 注意：严格遵守编码规范要求
 */
public class TestInvocationHandler implements InvocationHandler{

	private Object target;
	public TestInvocationHandler(Object target) {
		this.target=target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke begin");
		System.out.println("method :"+ method.getName()+" is invoked!");
		method.invoke(target,args);
		System.out.println("invoke end");
		return null;
	}

	public static void main(String[] args) throws Exception{

		TestInvocationHandler testInvocationHandler = new TestInvocationHandler(new SayImpl());
		Say say = (Say) Proxy
				.newProxyInstance(SayImpl.class.getClassLoader(), SayImpl.class.getInterfaces(),
								  (InvocationHandler) testInvocationHandler);
		say.sayHello("my dear");
	}


}
