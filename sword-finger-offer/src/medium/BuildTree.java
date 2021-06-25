package medium;

import data.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/6/24 1:29 下午
 * @Version: 1.0
 */
public class BuildTree {
    int[] preorder;
    Map<Integer,Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder,int[] inorder){
        this.preorder = preorder;
        for(int i=0;i<inorder.length;i++){
            dic.put(inorder[i],i);
        }

        return recur(0,0,inorder.length-1);
    }

    private TreeNode recur(int root, int left, int right) {
        if(left>right){ // 递归终止
            return null;
        }

        TreeNode node = new TreeNode(preorder[root]); // 建立根结点
        int i  = dic.get(preorder[root]); // 根结点在中序遍历的位置，该位置左边为左子树，右边为右子树
        node.left = recur(root+1,left,i-1); // 左子树递归
        node.right = recur(root+i-left+1,i+1,right);
        return node;
    }
}
