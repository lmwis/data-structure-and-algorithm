package medium;

/**
 * @Description: 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @Author: lmwis
 * @Date 2020-12-09 9:53
 * @Version 1.0
 */
public class UniquePaths {
    /**
     * 组合数学
     * 从左上角到右下角
     *  向左走m-1次
     *  向下走n-1次
     *  共移动m+n-2次
     *  路径总数，就等于从m+n-2次移动中选择m-1次向下移动的组合数
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
