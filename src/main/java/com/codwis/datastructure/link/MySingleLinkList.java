package com.codwis.datastructure.link;

/**
 * @author tao.wang02
 * @项目名称:
 * @文件名称:
 * @Date: 2018/2/22
 * @Copyright: www.msxf.com Inc. All rights reserved.
 * 注意：严格遵守编码规范要求
 */
public class MySingleLinkList {

	//遍历链表 获得链表的结点个数 看看当前结点的下一个指向是否为空来结束遍历
    public int listLength(ListNode headNode){
    	int length = 0;
    	ListNode currentNode = headNode;
    	while (currentNode.next!=null){//当前结点的指针为null的时候，说明到达链表表尾
			length++;
			currentNode = currentNode.getNext();//让当前结点指向下一个结点
		}
		return length;
	}

 public ListNode insertInLinkedList(ListNode headNode,
									ListNode nodeToInsert,int position){
    	if(headNode == null) // 1 判断链表是否为空
    		return nodeToInsert;
    	int size  = listLength(headNode);//得到链表的长度
	    //判断位置是否在链表的长度内
	   if(position > size+1 || position < 1){
		   System.out.println("position paragrems is invalid");
		   return headNode;
	   }

	   //链表插入分为两种情况，从链表头的插入和链表中间(包括末尾)
	   if(position == 1){
	   	 nodeToInsert.setNext(headNode);
	   	 return nodeToInsert;
	   }else {
	   	  ListNode previousNode = headNode;
	   	  int count = 1;
	   	  while (count < position - 1){
	   	  	previousNode = previousNode.getNext();
	   	  	count++;
		  }
		  ListNode currentNode = previousNode.getNext();
	   	  nodeToInsert.setNext(currentNode);
	   	  previousNode.setNext(nodeToInsert);
	   }
	   return headNode;
 }




























	//链表的结点类
	class ListNode{
		private int data;
		private ListNode next;
		public ListNode(int data){
			this.data = data;
		}
		public int getData(){
			return data;
		}
		public void setData(int data){
			this.data = data;
		}
		public ListNode getNext(){
			return next;
		}
		public void setNext(ListNode next){
			this.next = next;
		}
	}

}
