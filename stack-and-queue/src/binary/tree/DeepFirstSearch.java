package binary.tree;

/**
 * @Description: 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例 1:
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * @Author: lmwis
 * @Date 2020-10-29 17:55
 * @Version 1.0
 */
public class DeepFirstSearch {
    public static void main(String[] args) {
        DeepFirstSearch deepFirstSearch = new DeepFirstSearch();
        BinaryTree binaryTree = new BinaryTree();
        System.out.println(deepFirstSearch.sumNumbers(binaryTree.getRoot()));
    }

    /**
     * DFS，深度优先遍历
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return dep(root,0);
    }
    public int dep(TreeNode node,int val){
        if(node ==null){
            return 0;
        }
        int sum = 10*val+node.val;
        if(node.left==null&&node.right==null){
            return sum;
        }else{
            return dep(node.left,sum)+dep(node.right,sum);
        }

    }
}
