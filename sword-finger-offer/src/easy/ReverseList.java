package easy;

import data.structure.ListNode;

/**
 * @Description: 剑指 Offer 24. 反转链表
 * 1->2->3->4->5->NULL
 * 5->4->3->2->1->NULL
 * @Author: lmwis
 * @Data: 2021/11/18 9:01 下午
 * @Version: 1.0
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode root = head;
        ListNode pre = null;
        while(root!=null){
            ListNode temp = root.getNext();
            root.setNext(pre);
            pre = root;
            root = temp;
        }
        return pre;
    }
}
