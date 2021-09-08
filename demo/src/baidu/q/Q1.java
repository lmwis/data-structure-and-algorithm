package baidu.q;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/7 7:17 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int[][] res = method(n, k, arr);
        for (int i = 0; i < n*k; i++) {
            for (int j = 0; j < n*k; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] method(int n, int k, int[][] arr) {
        int N = n * k;
        int[][] res = new int[N][N];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pix = arr[i][j];
                for (int pj = j*k; pj < j*k+k; pj++) {
                    for (int pi = i*k; pi <i*k+k; pi++) {
                        res[pi][pj] = pix;
                    }
                }
            }
        }
        return res;
    }
}
