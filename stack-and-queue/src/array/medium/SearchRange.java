package array.medium;

/**
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * @Author: lmwis
 * @Date 2020-12-01 16:11
 * @Version 1.0
 */
public class SearchRange {
    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(new int[]{0},0);
    }

    /**
     * 方法一：二分查找
     * 直观的思路肯定是从前往后遍历一遍。用两个变量记录第一次和最后一次遇见 \textit{target}target 的下标，但这个方法的时间复杂度为 O(n)O(n)，没有利用到数组升序排列的条件。
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int front = 0;
        int length = nums.length;
        int back = length-1;
        boolean frontFlag = false;
        boolean backFlag = false;
        while(front<length&&back>=0){
            if(!frontFlag){
                if(nums[front]!=target){
                    front++;
                }else{
                    frontFlag = true;
                }
            }
            if(!backFlag){
                if(nums[back]!=target){
                    back--;
                }else{
                    backFlag = true;
                }
            }
            if(frontFlag&&backFlag){
                return new int[]{front,back};
            }
        }
        return new int[]{-1,-1};
    }

}
