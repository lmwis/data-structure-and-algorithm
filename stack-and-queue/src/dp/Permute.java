package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 46. [经典回溯]全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @Author: lmwis
 * @Date 2020-12-08 20:45
 * @Version 1.0
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums.length,path,0,res,nums,used);

        return res;
    }

    /**
     *
     * @param size 二叉树总深度，为数组长度
     * @param path 路径数据
     * @param dep 当前深度
     * @param res 结果
     * @param nums 数据
     * @param used 是否访问过
     */
    public void dfs(int size,List<Integer> path,int dep,List<List<Integer>> res,int[] nums,boolean[] used){
        if(size==dep){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]==false){
                used[i] = true;
                path.add(nums[i]);
                // 递归遍历
                dfs(size,path,dep+1,res,nums,used);
                // 回溯操作
                path.remove(path.size()-1);
                used[i] = false;
            }
        }

    }

}
