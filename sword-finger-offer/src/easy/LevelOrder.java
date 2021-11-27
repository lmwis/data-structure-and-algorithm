package easy;

import data.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @Author: lmwis
 * @Data: 2021/11/27 5:06 下午
 * @Version: 1.0
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        new LevelOrder().levelOrder(node1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int preCount = 0;
        int curCount = 1;
        while(!queue.isEmpty()){
            preCount = curCount;
            curCount = 0;
            List<Integer> floor = new ArrayList<>();
            while(preCount>0){
                preCount--;
                TreeNode temp = queue.poll();
                if(temp==null){
                    continue;
                }
                floor.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                    curCount++;
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                    curCount++;
                }
            }
            res.add(floor);
        }
        return res;
    }
}
