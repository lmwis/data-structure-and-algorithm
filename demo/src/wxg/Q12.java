package wxg;

import java.util.Scanner;

/**
 * @Description: 2.回形矩阵是由1开始的自然数逆时针排列成的一个n*n矩阵,n为奇数.
 * *
 * *  1 16 15 14 13
 * *  2 17 24 23 12
 * *  3 18 25 22 11
 * *  4 19 20 21 10
 * *  5   6   7   8   9
 * *
 * * 要求打印出它的一个子矩阵(m*m),例如在n=5的矩阵里面以起始点 xy( 2,3 ) 打印m = 2的正方形，则输出:
 * * 24 23
 * * 25 22
 * *
 * * 进阶： 是否可以应对超大规模的情况，例如n > 10000000,m<100的场景
 * @Author: lmwis
 * @Data: 2021/9/22 8:52 下午
 * @Version: 1.0
 */
public class Q12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int index = 1;
        int i;
        int j;
        int[][] mx = new int[n][n];
        for (int k = 0; k < n / 2; k++) {
            for (i = k, j = k; i < n - k - 1; i++) {
                mx[i][j] = index++;
            }
            for (i = n - k - 1, j = k; j < n - k - 1; j++) {
                mx[i][j] = index++;
            }
            for (i = n - k - 1, j = n - k - 1; i > k; i--) {
                mx[i][j] = index++;
            }
            for (i = k, j = n - k - 1; j > k; j--) {
                mx[i][j] = index++;
            }
        }
        if (n % 2 == 1) {
            mx[n / 2][n / 2] = index;
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if (k+1==x&&l+1==y){
                    int km = k+m;
                    int lm = l+m;
                    for (int o = k; o < km; o++) {
                        for (int p = l; p < lm; p++) {
                            System.out.print(mx[o][p] + " ");
                        }
                        System.out.println();
                    }

                }
            }
        }
    }
}
