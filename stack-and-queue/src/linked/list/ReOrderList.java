package linked.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 重排链表
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
