package array.easy;

/**
 * @Description: 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * @Author: lmwis
 * @Data: 2021/7/4 4:49 下午
 * @Version: 1.0
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] flag = new int[n+1];
        int[] res = new int[2];
        for (int num : nums) {
            if (flag[num] != 0) {
                res[0] = num;
            } else {
                flag[num] = 1;
            }
        }
        for(int i=1;i<=n;i++){
            if(flag[i]==0){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
