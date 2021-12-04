package easy;

import java.util.Scanner;

/**
 * @Description: 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * @Author: lmwis
 * @Data: 2021/12/1 4:12 下午
 * @Version: 1.0
 */
public class TwoSum {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str ="";
        while(in.hasNext()){
            str =str + in.nextLine();
        }

        int index = 0;
        int count = 0;
        while(true){
            index = str.indexOf("SUST");
            if (index<0){
                break;
            }else{
                count++;
            }
            str = str.substring(index+4);
        }
        System.out.println(count);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length-1;
        while(true){
            if(nums[left]+nums[right]==target){
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
            if((target-nums[left])<nums[right]){
                right--;
            }
            if((target-nums[left])>nums[right]){
                left++;
            }
        }

        return res;
    }
}
