package easy;

/**
 * @Description: 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @Author: lmwis
 * @Data: 2021/11/24 1:48 下午
 * @Version: 1.0
 */
public class MaxSubArray {
    public static void main(String[] args) {
        new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            if (pre<0){
                pre = nums[i];
            }
            else {
                pre = pre+nums[i];
            }
            max = Math.max(pre,max);
        }
        return max;
    }
}
