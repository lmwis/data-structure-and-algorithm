package array.hard;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Description: 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * @Author: lmwis
 * @Date 2021-01-02 18:47
 * @Version 1.0
 */
public class MaxSlidingWindow {

    /**
     * 该算法超时
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowFail(int[] nums, int k) {
        if(nums.length==1) return nums;
        int[] res = new int[nums.length-k+1];
        // 优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        int left = 0;
        int right = k-1;
        int count =0;
        do{
            res[count] = queue.peek(); // 取出最大
            count++;
            // 窗口右移
            left++;
            right++;
            if(right>=nums.length){
                break;
            }
            // 删除窗口外
            queue.remove(nums[left-1]);
            // 加入刚进窗口的
            queue.add(nums[right]);
        }while(true);

        return res;
    }

    /**
     * 双向队列题解算法
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

}
