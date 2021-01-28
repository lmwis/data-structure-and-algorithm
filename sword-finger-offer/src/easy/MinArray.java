package easy;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-01-28 12:27
 * @Version 1.0
 */
public class MinArray {
    /**
     * 简单思路：找到不升序的第一个
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {

        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]>numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }

    /**
     * 算法流程：
     * 初始化： 声明 ii, jj 双指针分别指向 numsnums 数组左右两端；
     * 循环二分： 设 m = (i + j) / 2m=(i+j)/2 为每次二分的中点（ "/" 代表向下取整除法，因此恒有 i \leq m < ji≤m<j ），可分为以下三种情况：
     * 当 nums[m] > nums[j]nums[m]>nums[j] 时： mm 一定在 左排序数组 中，即旋转点 xx 一定在 [m + 1, j][m+1,j] 闭区间内，因此执行 i = m + 1i=m+1；
     * 当 nums[m] < nums[j]nums[m]<nums[j] 时： mm 一定在 右排序数组 中，即旋转点 xx 一定在[i, m][i,m] 闭区间内，因此执行 j = mj=m；
     * 当 nums[m] = nums[j]nums[m]=nums[j] 时： 无法判断 mm 在哪个排序数组中，即无法判断旋转点 xx 在 [i, m][i,m] 还是 [m + 1, j][m+1,j] 区间中。解决方案： 执行 j = j - 1j=j−1 缩小判断范围，分析见下文。
     * 返回值： 当 i = ji=j 时跳出二分循环，并返回 旋转点的值 nums[i]nums[i] 即可。
     * @param numbers
     * @return
     */
    public int minArrayDivideTwo(int[] numbers){

        int i=0;
        int j=numbers.length-1;
        while(i!=j){
            int m = (i+j)/2;
            if(numbers[m]>numbers[j]){
                i=m+1;
            }else if(numbers[m]<numbers[j]){
                j=m;
            }else{
                j--;
            }
        }
        return numbers[i];
    }
}
