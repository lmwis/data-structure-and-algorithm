package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @Author: lmwis
 * @Date 2020-11-10 12:25
 * @Version 1.0
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeNode node = root;
        if(node==null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int level=1;
        while(queue.size()!=0){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            while(size-->0){
                TreeNode temp = queue.pop();
                stack.push(temp.val);
                if(level%2==1){ // 不需要翻转
                    list.add(temp.val);
                }
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }

            }
            if(level%2==0){ // 需要翻转
                while(!stack.empty()){
                    list.add(stack.pop());
                }
            }
            level++;
            res.add(list);
        }
        return res;
    }

}
