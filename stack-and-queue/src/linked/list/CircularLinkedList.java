package linked.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:查找循环链表的循环部分
 * @Author: lmwis
 * @Date 2020-10-11 14:22
 * @Version 1.0
 */
public class CircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        LinkedList linkedList = new LinkedList();
        ListNode listNode = circularLinkedList.detectCycle(linkedList.root);
        System.out.println(listNode.value);
    }

    public ListNode detectCycle(ListNode head) {
        int pose=-1;
        List<ListNode> nodes = new ArrayList();
        nodes.add(head);

        while(head.next==null||!nodes.contains(head.next)  ){
            if(head.next==null){
                return null;
            }
            pose++;
            head = head.next;
            nodes.add(head);
        }

        return nodes.get(pose-1);
    }
}
