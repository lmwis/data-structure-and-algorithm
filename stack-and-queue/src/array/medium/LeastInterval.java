package array.medium;

/**
 * @Description: 621. 任务调度器
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，
 * 并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或
 * 者在待命状态。
 *示例 1：
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所
 *      以中间出现了（待命）状态。你需要计算完成所有任务所需要的 最短时间 。
 * @Author: lmwis
 * @Date 2020-12-05 14:52
 * @Version 1.0
 */
public class LeastInterval {
    public static void main(String[] args) {
        new LeastInterval().leastInterval(new char[]{'A','A','A','B','B','B'},2);
    }

    /**
     * 桶思想
     * https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] temp = new int[26];
        int countMaxTask = 0;
        int maxTask=0;
        for(char c:tasks){
            temp[c-'A']++;
            maxTask = Math.max(temp[c-'A'],maxTask);
        }
        for(int i=0;i<26;i++){
            if(temp[i]==maxTask){
                countMaxTask++;
            }
        }
        return Math.max(tasks.length,(maxTask-1)*(n+1)+countMaxTask);
    }
}
