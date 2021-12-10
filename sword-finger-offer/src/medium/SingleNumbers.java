package medium;

import java.util.Arrays;

/**
 * @Description: 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * @Author: lmwis
 * @Data: 2021/12/10 1:55 下午
 * @Version: 1.0
 */
public class SingleNumbers {
    public static void main(String[] args) {
        Arrays.stream(new SingleNumbers().singleNumbers(new int[]{1, 1, 4, 3, 5, 4, 3})).forEach(System.out::println);
    }
    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x^=num;
        }
        int m=1;
        while((x&m)==0){
            m <<= 1;
        }
        int a=0;
        int b=0;
        for (int num : nums) {
            if ((num&m)==0){
                a^=num;
            }else{
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}
