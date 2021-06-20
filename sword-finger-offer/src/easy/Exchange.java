package easy;

/**
 * @Description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * @Author: lmwis
 * @Data: 2021/6/20 12:11 下午
 * @Version: 1.0
 */
public class Exchange {
    /**
     * 还可以快慢双指针
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int pre=0;
        int end = nums.length-1;
        while(pre<end){
            if(nums[pre]%2==0 && nums[end]%2!=0){
                int temp = nums[end];
                nums[end] = nums[pre];
                nums[pre] = temp;
            }
            if(nums[pre]%2!=0){
                pre++;
            }
            if(nums[end]%2==0){
                end--;
            }
        }
        return nums;
    }
}
