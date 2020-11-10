package binary.tree;

import java.util.*;

/**
 * @Description: 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @Author: lmwis
 * @Date 2020-11-10 11:55
 * @Version 1.0
 */
public class LevelOrderTraversal {

    /**
     * BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode node = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res= new ArrayList<>();
        if(root ==null){
            return res;
        }
        queue.offer(node);
        while(queue.size()!=0){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            while(n-->0){
                TreeNode temp = queue.pop();
                list.add(temp.val);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            res.add(list);
        }
        return res;
    }
    /**
     * 层序遍历模板
     */
    // 二叉树的层序遍历
    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                // 变量 i 无实际意义，只是为了循环 n 次
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

}
