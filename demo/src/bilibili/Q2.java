package bilibili;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/13 7:36 下午
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            int n = in.nextInt();
            int m = in.nextInt();
            if (n==-1 && m==-1) return;
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            int a = 0;
            int b = m-1;
            int c = n-1;
            int d = 0;
            int[] res = new int[n*m];
            int index=0;
            while(true){

                // 遍历行
                // 遍历列
                if (index>=n*m){
                    break;
                }
                for (int i = d; i <= b ; i++) {
                    res[index++] = arr[a][i];

                }
                a++;
                if (index>=n*m){
                    break;
                }
                for (int i = a; i <=c ; i++) {
                    res[index++] = arr[i][b];

                }
                b--;
                if (index>=n*m){
                    break;
                }

                for (int i = b; i >=d ; i--) {
                    res[index++] = arr[c][i];

                }
                c--;
                if (index>=n*m){
                    break;
                }
                for (int i = c; i >=a ; i--) {
                    res[index++] = arr[i][d];

                }
                d++;

            }
            for (int i = 0; i < res.length-1; i++) {
                System.out.print(res[i]+",");
            }
            System.out.print(res[res.length-1]);
        }
    }
}
