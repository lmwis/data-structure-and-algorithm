package ali;

import java.util.Scanner;

/**
 * @Description: 3.15 阿里笔试第二题
 * @Author: lmwis
 * @Date 2021-03-19 16:13
 * @Version 1.0
 */
public class Q2 {

    private static double dfs(int n, int cnt) {
        if (n == 1) return 1.0;
        double res = 0.0;
        for (int j = 1;j < n;j++) {
            int a = Math.max(j, n - j);
            int b = Math.min(j, n - j);
            if (a - b >= 2 && cnt == 0) {
                res += 1.0 / (n - 1) * (dfs(a - b, 1) + b);
            } else {
                res += 1.0 / (n - 1) * a;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.printf("%.4f\n", dfs(n, 0));
    }
}
