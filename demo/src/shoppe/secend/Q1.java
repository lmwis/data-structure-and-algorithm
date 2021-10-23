package shoppe.secend;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/10/11 7:31 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        System.out.println(padovanSequence(10));
    }
    public static int padovanSequence(int n) {
        // write code here
        if(n<=3){
            return 1;
        }else if(n==4){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for(int i=4;i<=n;i++){
            dp[i] = dp[i-3]+dp[i-2];
        }
        return dp[n];
    }
}
