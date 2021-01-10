package array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间
 * 范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * @Author: lmwis
 * @Date 2021-01-10 16:23
 * @Version 1.0
 */
public class SummaryRanges {
    public static void main(String[] args) {
        new SummaryRanges().summaryRanges(new int[]{0,1,2,4,5,7}).forEach(System.out::println);
    }
    public List<String> summaryRanges1(int[] nums) {
        List<String> lists = new ArrayList<>();
        if (nums.length == 0) {
            return lists;
        }
        int left = nums[0];
        int right = nums[0];
        if (nums.length == 1) {
            lists.add(nums[0] + "");
            return lists;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) { // 表示不连续
                if (left == right) {
                    lists.add(left + "");
                } else {
                    lists.add(left + "->" + right);
                }
                left = nums[i];
                right = nums[i];
                if (i == nums.length - 1) { //到结尾
                }
                right = nums[i];
                if (i == nums.length - 1) { //到结尾
                    if (nums[i - 1] + 1 == nums[i]) { //连续到结尾
                        if (left == right) {
                            lists.add(left + "");
                        } else {
                            lists.add(left + "->" + right);
                        }
                    } else {
                        lists.add(right + "");
                    }
                }
            }
        }
        return lists;
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> lists = new ArrayList<>();
        if(nums.length==0){
            return lists;
        }
        int left = nums[0];
        int right = nums[0];
        if(nums.length==1){
            lists.add(nums[0]+"");
            return lists;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1!=nums[i]){ // 表示不连续
                if(left==right){
                    lists.add(left+"");
                }else{
                    lists.add(left+"->"+right);
                }
                left = nums[i];
                right = nums[i];
                if(i==nums.length-1){ //到结尾
                    lists.add(nums[i]+"");
                }
            }else{ // 连续
                right = nums[i];
                if(i==nums.length-1){ //到结尾
                    if(left==right){
                        lists.add(left+"");
                    }else{
                        lists.add(left+"->"+right);
                    }
                }
            }

        }
        return lists;
    }
}
