package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * 二叉树的前序遍历
 * 前 左 右
 * 基本思想：维护一个栈，每遍历到节点就压入栈
 *  先向下遍历左子树，左子树若为空便退回（出栈）
 *  然后遍历右子数
 * @Author: lmwis
 * @Date 2020-09-30 13:12
 * @Version 1.0
 */
public class PreOrderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinarySearchTree();
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        // 输出前序序列
        preOrderTraversal.preOrder(binaryTree.getRoot()).forEach(System.out::print);
    }

    /**
     * @param root 二叉树根节点
     * @return
     */
    protected List<Integer> preOrder(TreeNode root){
        // 遍历结果
        List<Integer> res = new ArrayList<>();
        // 栈
        Stack<TreeNode> stack = new Stack<>();
        // 保存当前节点
        TreeNode temp = root;
        // 栈中有元素或者temp不为空
        while (temp!=null || !stack.empty()){

            if(temp!=null){
                res.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            }else{ // 左子树为空
                temp = stack.pop().right;
            }
        }
        return res;

    }
}
