package com.codwis.datastructure.link;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称:双端链表
 * @Date: 2018/2/9
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 注意：严格遵守编码规范要求
 */
public class FirstLastLinkList {
	//头结点
	private Node first;
	//尾结点
	private Node last;

	public FirstLastLinkList() {
		first = null;
		last = null;
	}

	/**
	 * 插入一个结点，在头结点后进行插入
	 */
	public void insertFirst(long value) {
		Node node = new Node(value);
		if(isEmpty()) {
			last = node;
		}
		node.next = first;
		first = node;
	}

	/**
	 * 插入一个结点，从尾结点进行插入
	 */
	public void insertLast(long value) {
		Node node = new Node(value);
		if(isEmpty()) {
			first = node;
		} else {
			last.next = node;
		}
		last = node;
	}

	/**
	 * 删除一个结点，在头结点后进行删除
	 */
	public Node deleteFirst() {
		Node tmp = first;
		if(first.next == null) {
			last = null;
		}
		first = tmp.next;
		return tmp;
	}

	/**
	 * 显示方法
	 */
	public void display() {
		Node current = first;
		while(current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * 查找方法
	 */
	public Node find(long value) {
		Node current = first;
		while(current.data != value) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}

	/**
	 * 删除方法，根据数据域来进行删除
	 */
	public Node delete(long value) {
		Node current = first;
		Node previous = first;
		while(current.data != value) {
			if(current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}

		if(current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;

	}

	/**
	 * 判断是否为空
	 */
	public boolean isEmpty() {
		return (first == null);
	}

	class Node {
		//数据域
		public long data;
		//指针域
		public Node next;
		public Node previous;

		public Node(long value) {
			this.data = value;
		}

		/**
		 * 显示方法
		 */
		public void display() {
			System.out.print(data + " ");
		}
	}
}
