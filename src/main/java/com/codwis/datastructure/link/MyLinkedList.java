package com.codwis.datastructure.link;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称:
 * @Date: 2018/2/24
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 注意：严格遵守编码规范要求
 */
public class MyLinkedList {

	public Node head;
	public Node current;

	public void add(int data) {

		//如果头结点为空,为头结点
		if(head == null) {
			head = new Node(data);
			current = head;
		} else {
			current.next = new Node(data);
			current = current.next;
		}
	}

	//打印链表
	public void print(Node node) {
		if(node == null) {
			return;
		}

		current = node;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	//初始化链表,并且返回表头
	public Node init() {
		for(int i=0; i<10; i++) {
			this.add(i);
		}
		return head;
	}

	//求链表长度
	public int get_length(Node head) {
		if (head == null) {
			return -1;
		}

		int length = 0;
		current = head;
		while(current != null) {
			length++;
			current = current.next;
		}

		return length;
	}

	public static Node ReversedLinkedList() {
		MyLinkedList list = new MyLinkedList();
		Node head = list.init();

		if(head == null || head.next == null) {
			return head;
		}

		//使用三个节指针
		Node current = head;
		Node newHead = null;
		Node next = null;

		while(current != null) {
			//先将当前节点的下个节点保存
			next = current.next;

			current.next = newHead; //将原来的链表断链,将current的下一个结点指向新链表的头结点
			newHead = current; //将current设为新表头

			current = next; //将之前保存的next设为下一个节点
		}
		return newHead;
	}

/*	public static void main(String[] args) {

	}*/

	public class Node<T> {

		public T data;
		public Node next;

		public Node(T data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		MyLinkedList list = new MyLinkedList();
		Node head = ReversedLinkedList();
		System.out.println("After reversed, the list is: ");
		list.print(head);

	/*
		MyLinkedList list = new MyLinkedList();
		Node head = list.init();
		list.print(head);

		int length = list.get_length(head);
		System.out.println();
		System.out.println("The length of list is: " + length);*/
	}
}
