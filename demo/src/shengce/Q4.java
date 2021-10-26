package shengce;

/**
 * @Description:
 * 1->2->3->….-> n
 * 1->n->2->n-1->3->…2/n
 * 1-2-3-4-5
 * 1-5-2-4-3
 * @Author: lmwis
 * @Data: 2021/10/25 4:38 下午
 * @Version: 1.0
 */
public class Q4 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = new Q4().method(node1);
        while (res.next!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public ListNode method(ListNode node){
        ListNode root = node;
        ListNode half = null;
        int n=1;
        ListNode temp = node;
        while (temp!=null){
            n++;
            temp = temp.next;
        }
        int i=0;
        temp = node;
        while (temp!=null){
            if (i==n/2){
                half = temp;
            }
            temp = temp.next;
            i++;
        }
        half = revers(half);
        temp = node;
        for (int j = 0; j < n/2-1; j++) {
            ListNode next = temp.next;
            temp.next = half;
            temp = next;
            ListNode next1 = half.next;
            half.next = temp;
            half = next1;
        }
        temp.next=null;
        return root;
    }

    /**
     * 1-2-3
     * @param node
     * @return
     */
    public ListNode revers(ListNode node){
        ListNode root = node;
        ListNode temp = root;
        ListNode pre = null;
        while(temp!=null){
           ListNode next = temp.next;
           temp.next = pre;
           pre = temp;
           temp = next;

        }
        return pre;
    }
}
class ListNode{
    ListNode next;
    int val;

    public ListNode(int val){
        this.val = val;
    }
}
