package array.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * @Author: lmwis
 * @Date 2020-12-30 12:26
 * @Version 1.0
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    /**
     * 优先队列
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        // 由于默认排序规则是升序，所以传一个逆序的Comparator接口
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
        Arrays.stream(stones).forEach(priorityQueue::add);
        while(priorityQueue.size()>1){
            Integer poll1 = priorityQueue.poll();
            Integer poll2 = priorityQueue.poll();
            if(poll1<poll2){
                priorityQueue.add(poll2-poll1);
            }else if(poll1>poll2){
                priorityQueue.add(poll1-poll2);
            }
        }
        return priorityQueue.size()==0?0:priorityQueue.poll();
    }

}
