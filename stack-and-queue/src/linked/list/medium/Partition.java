package linked.list.medium;

import linked.list.ListNode;

/**
 * @Description: 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例：
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * @Author: lmwis
 * @Date 2021-01-03 13:00
 * @Version 1.0
 */
public class Partition {
    /**
     * 时间O(n) 空间O(1)
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0,null);
        ListNode larger = new ListNode(0,null);
        // 头结点
        ListNode smallerPoint = smaller;
        // 头结点
        ListNode largerPoint = larger;
        ListNode root = head;
        while(root!=null){
            // 小于等于放在前面的链表
            if(root.val < x){
                smaller.next = root;
                smaller = smaller.next;
            }else {
                larger.next = root;
                larger = larger.next;
            }
            root = root.next;
        }
        larger.next = null;
        smaller.next = largerPoint.next;
        return smallerPoint.next;
    }
}
