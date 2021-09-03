package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 *
 * @Author: lmwis
 * @Data: 2021/9/3 1:06 下午
 * @Version: 1.0
 */
public class SmallestK {

    /**
     * 优先队列
     * 时间复杂度 nlogn
     * 空间负责度 n
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        Arrays.stream(arr).forEach(queue::add);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    /**
     * Arrays.sort()
     * 时间 nlogn
     * 空间 nlogn
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestKArraysSort(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        Arrays.stream(arr).forEach(queue::add);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
