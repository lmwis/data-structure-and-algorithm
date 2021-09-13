package meituan.qiu;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/11 5:35 下午
 * @Version: 1.0
 */
public class Q4 {
    /**
     * 27
     * 前一个段的最大值小于后一个段的最小值
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int res = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int left = 0;
        int right = 1;
        while(left<n){
            if (arr[left]<arr[right]){
                int tempRight = right;
                boolean flag = true;
                while(tempRight<n){
                    if(arr[tempRight]<arr[left]){
                        flag = false;
                        break;
                    }
                    tempRight++;
                }
                if (flag){
                    res++;
                    left = right;
                    right = left+1;
                }
            }else{
                if (right==n-1){
                    res++;
                    break;
                }
                right++;
            }

        }
        System.out.println(res);
    }
}
