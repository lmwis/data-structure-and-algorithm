package easy;

import data.structure.ListNode;

/**
 * @Description: 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * @Author: lmwis
 * @Data: 2021/6/26 12:51 下午
 * @Version: 1.0
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0,null);
        ListNode temp = root;
        while(l1!=null && l2!=null){
            if(l1!=null && l1.getValue()<=l2.getValue()){
                temp.setNext(l1);
                l1 = l1.getNext();
            }else{
                temp.setNext(l2);
                l2 = l2.getNext();
            }
            temp = temp.getNext();
        }

        temp.setNext(l2==null?l1:l2);
        return root.getNext();
    }
}
