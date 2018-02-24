package com.codwis.datastructure.stack;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称: 数组实现的栈
 * @Date: 2018/2/9
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 注意：严格遵守编码规范要求
 */
public class ArrayStack {
	//底层实现是一个数组
	private long[] arr;
	private int top;

	/**
	 * 默认的构造方法
	 */
	public ArrayStack() {
		arr = new long[10];
		top = -1;
	}

	/**
	 * 带参数构造方法，参数为数组初始化大小
	 */
	public ArrayStack(int maxsize) {
		arr = new long[maxsize];
		top = -1;
	}

	/**
	 * 添加数据
	 */
	public void push(int value) {
		arr[++top] = value;
	}

	/**
	 * 移除数据
	 */
	public long pop() {
		return arr[top--];
	}

	/**
	 * 查看数据
	 */
	public long peek() {
		return arr[top];
	}

	/**
	 * 判断是否为空
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * 判断是否满了
	 */
	public boolean isFull() {
		return top == arr.length - 1;
	}
}
