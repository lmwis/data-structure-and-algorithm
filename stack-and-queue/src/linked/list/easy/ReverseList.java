package linked.list.easy;

import linked.list.ListNode;

/**
 * @Description: 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author: lmwis
 * @Date 2020-12-07 15:21
 * @Version 1.0
 */
public class ReverseList {
    /**
     * 递推反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode preve = null;
        ListNode current = head;
        while(current!=null){
            ListNode temp = current.next ;
            current.next = preve;
            preve = current;
            current = temp;
        }
        return preve;
    }
}
