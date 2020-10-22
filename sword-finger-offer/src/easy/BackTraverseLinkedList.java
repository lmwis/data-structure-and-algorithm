package easy;

import data.structure.LinkedList;
import data.structure.ListNode;

import java.util.Stack;

/**
 * @Description: 从尾到头打印链表
 * @Author: lmwis
 * @Date 2020-10-22 10:10
 * @Version 1.0
 */
public class BackTraverseLinkedList {

    public static void main(String[] args) {
        BackTraverseLinkedList backTraverseLinkedList = new BackTraverseLinkedList();
        // 3->2->0->-4
        LinkedList linkedList = new LinkedList();
        for (int i : backTraverseLinkedList.reversePrint(linkedList.root)) {
            System.out.println(i);
        }
    }

    /**
     * 利用栈
     * @param root
     * @return
     */
    private int[] reversePrint(ListNode root) {
        ListNode node = root;
        Stack<ListNode> stack = new Stack<>();
        stack.push(node);
        int length=0;
        while(node.getNext()!=null){
            node = node.getNext();
            stack.push(node);
            length++;
        }
        ListNode temp = stack.pop();
        int i =0;
        int[] res = new int[length+1];
        while(!stack.empty()){
            res[i++] = temp.getValue();
            temp = stack.pop();
        }
        res[i++] = temp.getValue();
        return res;
    }
}
