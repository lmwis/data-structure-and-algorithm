package futo;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/12 4:01 下午
 * @Version: 1.0
 */
public class Q2 {
    public ListNode changeListNode (ListNode head, int pivot) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp);
            temp = temp.next;
        }
        List<ListNode> left = new ArrayList<>();
        List<ListNode> mid = new ArrayList<>();
        List<ListNode> right = new ArrayList<>();
        for(ListNode node : list){
            if(node.val<pivot){
                left.add(node);
            }else if(node.val==pivot){
                mid.add(node);
            }else{
                right.add(node);
            }
        }
        ListNode res = new ListNode();
        ListNode t = res;
        for(ListNode node : left){
            t.next = node;
            t = t.next;
        }
        for(ListNode node : mid){
            t.next = node;
            t = t.next;
        }
        for(ListNode node : right){
            t.next = node;
            t = t.next;
        }

        return res.next;
        // write code here
    }

    public ListNode changeListNode2 (ListNode head, int pivot) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            if(list.get(left).val>list.get(right).val){
                ListNode t1 = list.get(left);
                list.set(left,list.get(right));
                list.set(right,t1);
            }
            left++;
            right--;
        }
        ListNode res = new ListNode();
        ListNode t = res;
        for (ListNode node : list) {
            t.next = node;
            t = t.next;
        }
        return res.next;
    }

    class ListNode{
        private int val;
        private ListNode next;
    }
}
