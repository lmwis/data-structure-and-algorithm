package easy;

import data.structure.ListNode;

/**
 * @Description: 剑指 Offer 52. 两个链表的第一个公共节点
 * @Author: lmwis
 * @Data: 2021/12/13 5:46 下午
 * @Version: 1.0
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA!=nodeB){
            nodeA = nodeA == null ? headB:nodeA.getNext();
            nodeB = nodeB == null ? headA:nodeB.getNext();
        }

        return nodeA;
    }
}
