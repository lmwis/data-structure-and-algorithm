package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * 中序遍历
 *  左 前 右
 * 可以借鉴前序遍历的思想
 * @Author: lmwis
 * @Date 2020-09-30 14:19
 * @Version 1.0
 */
public class InOrderTraversal {

    public static void main(String[] args) {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        BinaryTree binaryTree = new BinaryTree();
        inOrderTraversal.inOrder(binaryTree.getRoot()).forEach(System.out::print);
    }

    private List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp!=null || !stack.empty()){
            if(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }else { // 当没有左子树的时候加入结果
                temp = stack.pop();
                res.add(temp.value);
                temp = temp.right;
            }
        }
        return res;
    }
}
