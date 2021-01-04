package easy;

/**
 * @Description: 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 *
 * 简单题不简单，最优是矩阵快速幂时间复杂度到O(logN)
 * @Author: lmwis
 * @Date 2021-01-04 12:04
 * @Version 1.0
 */
public class Fib {
    /**
     * 自己写的O(n) O(n) 过于辣鸡
     * @param n
     * @return
     */
    public int fib(int n) {
        int[] dp = new int[n+3];
        dp[0] = 0 ;
        dp[1] = 1;
        if(n==0 || n==1) return dp[n];
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 官方O(1)空间解法，牛
     * 我是傻逼
     * @param n
     * @return
     */
    public int fibO1(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
