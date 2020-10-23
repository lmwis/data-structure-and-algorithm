package data.structure;

import java.util.Arrays;

/**
 * @Description: 链表
 * @Author: lmwis
 * @Date 2020-10-11 14:09
 * @Version 1.0
 */
public class LinkedList {
    public ListNode root;

    public LinkedList() {
//        this.root = new ListNode(3);

        // [3,2,0,-4]
        // 1
        ListNode node1 = new ListNode(2, null);
        ListNode node2 = new ListNode(7, null);
        ListNode node3 = new ListNode(4, null);
        ListNode node4 = new ListNode(3, null);
        ListNode node5 = new ListNode(5, null);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next = node5;
        node5.next=null;
//        this.root = node1;
//        ListNode node1 = new ListNode(1, null);
//        ListNode node2 = new ListNode(2, null);
//        node1.next=node2;
//        node2.next=null;
        this.root = node1;
    }

    public LinkedList(int[] array) {
        this.root = new ListNode(array[0],null);
        int[] newArr = new int[array.length-1];
        System.arraycopy(array,1,newArr,0,array.length-1);
        root.setNext(getNode(root,newArr));
    }
    public ListNode getNode(ListNode node,int[] array){
        if(array.length==1){
            return new ListNode(array[0],null);
        }else{
            int[] newArr = new int[array.length-1];
            System.arraycopy(array,1,newArr,0,array.length-1);
            node.setNext(getNode(node,newArr));
            node.setValue(array[0]);
            return node;
        }

    }
}

