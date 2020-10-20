package binary.tree;

/**
 * @Description: 二叉搜索树
 * 定义：对于任意节点而言，其左子树上的节点值均小于该节点，其右子树上的节点值均大于该节点
 * @Author: lmwis
 * @Date 2020-09-30 15:02
 * @Version 1.0
 */
public class BinarySearchTreeInsert {

    public static void main(String[] args) {
        BinarySearchTreeInsert binarySearchTree = new BinarySearchTreeInsert();
        BinaryTree binaryTree = new BinarySearchTree();

        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        System.out.print("插入前的先序序列为：");
        preOrderTraversal.preOrder(binaryTree.getRoot()).forEach(System.out::print);
        System.out.println();
        // 插入
        TreeNode root = binarySearchTree.insert(binaryTree.getRoot(), 6);

        System.out.print("插入后的先序序列为：");
        preOrderTraversal.preOrder(root).forEach(System.out::print);
    }

    private TreeNode insert(TreeNode root, int value) {
        TreeNode node = new TreeNode(value);
        // root为空则直接新建根节点返回
        if (root == null) {
            return node;
        }
        // 可以看做指向某个节点的指针
        TreeNode cur = root;
        while (true) {
            // 目标值小于则该放在左子树上
            if (value < cur.value) {
                // 左子树为空则为插入位置
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            } else { // 等于的话放在哪边都是满足的
                if (cur.right == null) {
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }
}
