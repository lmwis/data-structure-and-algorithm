package array.medium;

/**
 * @Description: 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * @Author: lmwis
 * @Date 2021-01-08 19:04
 * @Version 1.0
 */
public class RotateArray {
    /**
     * 时间 O(kn) 空间O(1)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        while(k>0){
            k--;
            doMoveLeft(nums);
        }
    }
    public void doMoveLeft(int[] nums){
        int pre1 = nums[nums.length-1];
        int current=0;
        for(int i =0;i<nums.length;i++){
            current = nums[i];
            nums[i] =  pre1;
            pre1 = current;
        }
    }


    /**
     * 环形替换
     * @param nums
     * @param k
     */
    public void rotateBest(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
