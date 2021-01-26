package array.easy;

/**
 * @Description: 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * @Author: lmwis
 * @Date 2021-01-26 13:34
 * @Version 1.0
 */
public class NumEquivDominoPairs {
    /**
     * 总之就是非常诡异
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] bucket = new int[100];
        int res = 0;
        for(int i=0;i<dominoes.length;i++){
            int val = dominoes[i][0]<dominoes[i][1]?dominoes[i][0]*10+dominoes[i][1]:dominoes[i][1]*10+dominoes[i][0];
            res += bucket[val];
            bucket[val]++;
        }
        return res;
    }
}
