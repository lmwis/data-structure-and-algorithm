package linked.list;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-11 14:09
 * @Version 1.0
 */
public class LinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new int[]{});
        System.out.println(linkedList);
    }

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
    ListNode root = null;
    public LinkedList(int[] arr) {
        if (arr!=null && arr.length!=0){
            root = new ListNode(0,null);
            ListNode temp = root;
            for (int i = 0; i < arr.length;i++){
                assert temp != null;
                temp.val = arr[i];
                temp.next = i==arr.length-1?null:new ListNode(0,null);
                temp = temp.next;
            }
        }
    }
}

