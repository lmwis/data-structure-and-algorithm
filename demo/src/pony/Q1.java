package pony;

import java.util.Scanner;

/**
 * @Description:
 * 相邻元素差的越小
 * @Author: lmwis
 * @Data: 2021/9/26 7:38 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        // Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n-1; i++) {
            sum+=Math.pow(Math.abs(arr[i+1]-arr[i]),2);
        }
        System.out.println(sum);
    }
}
