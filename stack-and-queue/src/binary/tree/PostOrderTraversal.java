package binary.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * 后序遍历
 *  先序：前 左 右
 *  中序：左 前 右
 *  后序：左 右 前
 *  所以后序遍历的思想就是把前序的左右记录交换，最后逆序输出
 * @Author: lmwis
 * @Date 2020-09-29 15:43
 * @Version 1.0
 */
public class PostOrderTraversal {

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        postOrderTraversal.postOrder(binaryTree.getRoot()).forEach(System.out::print);
    }

    private List<Integer> postOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode temp = root;
        while (temp!=null || !stack.empty()){
            if(temp!=null){
                res.add(temp.val);
                stack.push(temp);
                // 先遍历左子树改为右子树
                temp = temp.right;
            }else {
                // 右子树为空再遍历左子树
                temp = stack.pop().left;
            }
        }
        // 逆序
        Collections.reverse(res);
        return res;
    }
}