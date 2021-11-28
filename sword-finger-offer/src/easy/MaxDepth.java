package easy;

import data.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/11/28 3:55 下午
 * @Version: 1.0
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int preCount = 0;
        int curCount = 1;
        while(!queue.isEmpty()){
            preCount = curCount;
            curCount = 0;
            List<Integer> floor = new ArrayList<>();
            while(preCount>0){
                preCount--;
                TreeNode temp = queue.poll();
                if(temp==null){
                    continue;
                }
                floor.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                    curCount++;
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                    curCount++;
                }
            }
            res.add(floor);
        }
        return res.size()   ;
    }
}
