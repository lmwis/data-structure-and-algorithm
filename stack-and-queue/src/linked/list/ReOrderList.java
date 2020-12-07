package linked.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: [字节题库]143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 最优解法使用O(1)空间：取链表中点，截取，反转
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * @Author: lmwis
 * @Date 2020-10-20 20:38
 * @Version 1.0
 */
public class ReOrderList {
    public static void main(String[] args) {
        ReOrderList reOrderList = new ReOrderList();
        LinkedList linkedList = new LinkedList();
        reOrderList.reorderList(linkedList.root);
        // 3 ->2->0->-4
        // 3->-4->2->0
    }

    /**
     * O(n)
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node!=null){
            list.add(node);
            node = node.next;
        }
        node = head;
        for(int i=list.size()-1;i>(list.size()/2-1);i--){
            ListNode temp = list.get(i);
            temp.next = node.next;
            node.next = temp;
            node = node.next.next;
        }
        node.next=null;

    }
}
