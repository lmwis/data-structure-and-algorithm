package linked.list;

import java.util.List;

/**
 * @Description: 判断链表是否回文
 * @Author: lmwis
 * @Date 2020-10-23 10:47
 * @Version 1.0
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        LinkedList linkedList = new LinkedList();
        System.out.println(palindrome.isPalindrome(linkedList.root));
    }

    /**
     * 1->2->2->1 为回文
     * 思路：将链表转为线性表，线性表容易判断是否回文
     * @param head
     * @return
     */
    boolean isPalindrome(ListNode head){
        ListNode node=head;
        List<Integer> arr = new java.util.LinkedList<>();
        while(node!=null){
            arr.add(node.val);
            node = node.next;
        }
        int[] res = arr.stream().mapToInt(Integer::valueOf).toArray();
        int i=0;
        int j=res.length-1;
        while(i<j){
            if(res[i]!=res[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
