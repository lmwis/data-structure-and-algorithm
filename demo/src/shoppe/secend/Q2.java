package shoppe.secend;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/10/11 7:48 下午
 * @Version: 1.0
 */
public class Q2 {

    static class TreeNode {
       int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }

      }

    public static void main(String[] args) {
        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        TreeNode q4 = new TreeNode(4);
        q1.left = q2;
        q1.right = q3;
        q3.left = q4;
        System.out.println(getMaxMoney(q1));
    }

    public static int getMaxMoney(TreeNode node) {
        // write code here
        int max = 0;
        int count = -1;

        Set<Integer> visit = new HashSet<>();
        while(visit.size()!=count){
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = node;
            queue.add(root);
            int tempMax = 0;
            int tempCount = 1;
            int[] mark = new int[101];
            boolean flag = true;
            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();

                if (temp.left!=null){
                    queue.add(temp.left);
                    tempCount++;
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                    tempCount++;
                }

                if(visit.contains(temp.val)){
                    continue;
                }
                if (flag&&!visit.contains(temp.val)){
                    flag=false;
                    visit.add(temp.val);
                }

                if(mark[temp.val]==1){
                    continue;
                }
                tempMax +=temp.val;
                if (temp.left!=null){

                    mark[temp.left.val] = 1;
                }
                if (temp.right!=null){
                    mark[temp.right.val] = 1;
                }

            }
            max = Math.max(max,tempMax);
            count = tempCount;
        }
        return max;
    }
}
