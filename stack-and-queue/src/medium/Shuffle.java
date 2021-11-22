package medium;

/**
 * @Description: 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 *
 * 示例：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 * @Author: lmwis
 * @Data: 2021/11/22 2:23 下午
 * @Version: 1.0
 */
public class Shuffle {
    int random ;
    int[] nums ;
    int[] shuffle;
    public Shuffle(int[] nums) {
        this.nums = nums;
        this.shuffle = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        random = (int)(Math.random()*shuffle.length);
        int[] tempArr = new int[shuffle.length];
        for(int i=0;i<shuffle.length;i++){
            int temp = (i+random)%shuffle.length;
            tempArr[i] = shuffle[temp];
        }
        shuffle = tempArr;
        return tempArr;
    }
}
