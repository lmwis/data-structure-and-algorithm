package binary.tree;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-09-30 17:17
 * @Version 1.0
 */
public class BinarySearchTree extends BinaryTree {

    BinarySearchTree(){
        // 5
        // |\
        // 3 8
        // |\|\
        // 1 4 7 9
        // 先序遍历：5314879
        // 中序遍历：1345789
        // 后序遍历：1437985
        root = new TreeNode(5,new TreeNode(3,new TreeNode(1,null,null)
                ,new TreeNode(4,null,null)),new TreeNode(8,new TreeNode(7,null,null)
                ,new TreeNode(9,null,null)));
    }

}
