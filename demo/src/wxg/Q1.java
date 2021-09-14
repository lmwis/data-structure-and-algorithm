package wxg;

/**
 * @Description:
 *
 * 1. 给定一个无序的整数数组，求出数组中的最长递增子序列的长度；
 * 例如， {7, 2, 3, 1, 5, 8, 9, 6}，最长递增子序列为{2, 3, 5, 8, 9}，长度为5。
 *
 * @Author: lmwis
 * @Data: 2021/9/14 5:42 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {

        System.out.println(new Q1().getMaxLength(new int[]{7, 2, 3, 1, 5, 8, 9, 6}));
    }
    public int getMaxLength(int[] arr){

        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <i ; j++) {
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
