import java.util.LinkedList;

/**
 * @Description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 1->2->4, 1->3->4
 * 1->1->2->3->4->4
 * @Author: lmwis
 * @Date 2021-03-13 19:41
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(5);
        ListNode node14 = new ListNode(6);
        node13.next = node14;
        node12.next = node13;
        node11.next = node12;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node22.next = node23;
        node21.next = node22;

        ListNode res = new Demo1().method(node11, node21);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }

    }


    public ListNode method(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1 != null || node2 != null) {
            if (node2 == null && node1 != null) {
                temp.next = node1;
                break;
            }
            if (node1 == null && node2 != null) {
                temp.next = node2;
                break;
            }
            if (node1.value > node2.value) {
//                temp.next = new ListNode(node2.value);
                temp.next =  node2;
                node2 = node2.next;
            } else {
//                temp.next = new ListNode(node1.value);
                temp.next =  node1;
                node1 = node1.next;
            }
            temp = temp.next;
        }
        return node.next;

    }
}

class ListNode {
    ListNode next;
    int value;

    public ListNode(int value) {
        this.value = value;
    }

}
