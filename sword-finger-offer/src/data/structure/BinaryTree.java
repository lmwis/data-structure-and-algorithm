package data.structure;

/**
 * @Description:
 * 先序：前 左 右
 * 中序：左 前 右
 * 后序：左 右 前
 * @Author: lmwis
 * @Date 2020-09-30 13:24
 * @Version 1.0
 */
public class BinaryTree {
    TreeNode root;
    BinaryTree(){
        // 1
        // |\
        // 2 4
        // |\|\
        // 8 5 9 3
        // 先序遍历：1285493
        // 中序遍历：8251943
        // 后序遍历：8529341
        root = new TreeNode(1,new TreeNode(2,new TreeNode(8,null,null)
                ,new TreeNode(5,null,null)),new TreeNode(4,new TreeNode(9,null,null)
                ,new TreeNode(3,null,null)));
    }

    TreeNode getRoot() {
        return root;
    }
}

