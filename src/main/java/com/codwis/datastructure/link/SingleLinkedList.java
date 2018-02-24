package com.codwis.datastructure.link;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称: 单链表
 * @Date: 2018/2/9
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 链表的基本操作:遍历链表||在链表中插入一个元素||在链表中删除一个元素
 * 注意：严格遵守编码规范要求
 */
public class SingleLinkedList {


	/**
	 * 遍历链表 获得链表的结点个数
	 * @param headNode
	 * @return
	 */
	public int listLength(ListNode headNode){
		int length=0;
		ListNode currentNode = headNode;
		while(currentNode!=null){
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}


	/** 链表的插入
	 *  从表头插入||从表尾插入 || 在链表中间插入
	 * @param headNode
	 * @param nodeToInsert
	 * @param position
	 * @return
	 */
	public ListNode insertInLinkedList(ListNode headNode,
									   ListNode nodeToInsert,int position){

		if(headNode == null) //先判断链表是否为空
			return nodeToInsert;
		int size = listLength(headNode);
		if(position>size+1||position<1){
			System.out.println("position of node is invalid.");
			return headNode;
		}

		if(position == 1){ //在链表开头插入
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		}else{
			//在链表中间或者末尾插入
			ListNode previousNode = headNode;
			int count = 1;
			while(count<position-1){
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}
		return headNode;
	}

	/**
	 * 删除单链表中的结点
	 * 也分三种情况 从表头删 从表尾删 从表中间删除
 	 * @param headNode
	 * @param position
	 * @return
	 */
	ListNode deleteNodeFromLinkedList(ListNode headNode,int position){
		int size = listLength(headNode);
		if(position>size||position<1){
			System.out.println("position of node id invalid.");
			return headNode;
		}

		if(position ==1){ //删除单链表的表头结点
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		} else{
			ListNode previousNode = headNode;
			int count = 1;
			while(count<position){
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		return headNode;
	}

	/**
	 * 删除单链表
	 * 描述:将当前结点存储在临时变量中然后释放当前结点(空间)的方式来完成
	 *      释放完当前结点后，移动到下一个结点并将其存储在临时变量中，然后递归
	 * @param head
	 */
	public void deleteLinkedList(ListNode head){
		ListNode auxilaryNode,iterator = head;
		while(iterator!=null){
			auxilaryNode = iterator.getNext();
			iterator = null;
			iterator = auxilaryNode;
		}
	}


	class ListNode {
		private int data;
		private ListNode next;
		public ListNode(int data){
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}
	}

}
