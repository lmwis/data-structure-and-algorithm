package linked.list;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-11 14:09
 * @Version 1.0
 */
public class LinkedList {
    ListNode root;

    public LinkedList() {
//        this.root = new ListNode(3);

        // [3,2,0,-4]
        // 1
        ListNode node1 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(0, null);
        ListNode node4 = new ListNode(-4, null);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
//        this.root = node1;
//        ListNode node1 = new ListNode(1, null);
//        ListNode node2 = new ListNode(2, null);
//        node1.next=node2;
//        node2.next=null;
        this.root = node1;
    }
}

