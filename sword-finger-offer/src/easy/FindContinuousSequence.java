package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @Author: lmwis
 * @Data: 2021/12/16 1:58 下午
 * @Version: 1.0
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        new FindContinuousSequence().findContinuousSequence(9);
    }
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        int left = 1;
        int right = 1;
        int cur = 1;
        while(left<(target/2+1)){
            if(cur==target){
                int count = right-left+1;
                int[] temp = new int[count];
                // add to result
                for (int i = 0; i < count; i++) {
                    temp[i] = left+i;
                }
                res.add(temp);
                cur-=left;
                left++;
            }
            if (cur<target){
                right++;
                cur+=right;
            }
            if (cur>target){
                cur-=left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}