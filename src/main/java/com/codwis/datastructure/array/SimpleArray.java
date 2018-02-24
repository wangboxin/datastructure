package com.codwis.datastructure.array;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称: java实现数组
 * @Date: 2018/2/9
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 注意：严格遵守编码规范要求
 */
public class SimpleArray {
	private long[] arr;
	//表示有效数据的长度
	private int elements;

	public SimpleArray() {
		arr = new long[50];
	}

	public SimpleArray(int maxsize) {
		arr = new long[maxsize];
	}

	/**
	 * 添加数据
	 */
	public void insert(long value) {
		arr[elements] = value;
		elements++;
	}

	/**
	 * 显示数据
	 */
	public void display() {
		System.out.print("[");
		for(int i = 0; i < elements; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}

	/**
	 * 查找数据
	 */
	public int search(long value) {
		int i;
		for(i = 0; i < elements; i++) {
			if(value == arr[i]) {
				break;
			}
		}

		if(i == elements) {
			return -1;
		} else {
			return i;
		}

	}

	/**
	 * 查找数据，根据索引来查
	 */
	public long get(int index) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return arr[index];
		}
	}

	/**
	 * 删除数据
	 */
	public void delete(int index) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			for(int i = index; i < elements; i++) {
				arr[index] = arr[index + 1];
			}
			elements--;
		}
	}

	/**
	 * 更新数据
	 */
	public void change(int index, int newvalue) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			arr[index] = newvalue;
		}
	}
}
