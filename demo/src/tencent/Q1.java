package tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/26 8:06 下午
 * @Version: 1.0
 */
public class Q1 {
    static int[] dp = new int[100000000];
    static int index = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = in.nextInt();
        }
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            res[i] = method(arr[i]);
        }
        Arrays.stream(res).forEach(System.out::println);
    }
    private static int getPrim(int x){
        if (x<=2){
            return x;
        }
        int maxdp = 2;
        for (int i = 0; i < x; i++) {
            if (dp[i]==0){
                break;
            }
            maxdp = dp[i];
            if (dp[i]>=x){
                return dp[i];
            }
        }
        int j;
        for (int i = maxdp; i < Integer.MAX_VALUE; i++) {
            for (j = 2; j < i; j++) {
                if (i%j==0){
                    break;
                }

            }
            if (j>=i&&i>=x){
                dp[index++] = i;
               return i;
            }
        }
        return 0;
    }
    private static int method(int x) {
        int b = getPrim(1+x);
        int c = b;
        while(true){
            int temp = getPrim(c+1);
            c = temp;
            if (temp-b>=x){
                break;
            }
        }
        return b*c;
    }
}
