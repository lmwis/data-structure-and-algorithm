package array.easy;

/**
 * @Description: 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * @Author: lmwis
 * @Date 2021-02-04 15:13
 * @Version 1.0
 */
public class FindMaxAverage {
    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int index = k;
        int temp = sum;
        while(index<nums.length){
            temp-=nums[index-k];
            temp+=nums[index];
            if(temp>sum){
                sum=temp;
            }
            index++;
        }
        return sum/(double)k;
    }
}
