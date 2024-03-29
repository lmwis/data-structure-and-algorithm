package easy;

import data.structure.ListNode;

/**
 * @Description: 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * @Author: lmwis
 * @Data: 2021/6/19 3:53 下午
 * @Version: 1.0
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.getValue() == val){return head.getNext();}
        ListNode pre = head;
        ListNode cur = head.getNext();
        while(pre!=null && cur.getValue() != val){
            pre = cur;
            cur = cur.getNext();
        }
        if(cur==null){
            pre.setNext(null);
        }else{
            pre.setNext(cur.getNext());
        }
        return head;
    }
}
