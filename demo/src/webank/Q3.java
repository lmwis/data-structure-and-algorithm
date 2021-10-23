package webank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/10/23 3:29 下午
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
//        boolean flag = false;
        int count=0;
        for (int i = 0; i < n; i++) {
            if (arr[i]<i+1){ // 往后找
                int t = i;
                while(arr[t]<i+1){
                    t++;
                    if (t>=n){
                        System.out.println(count+1);
                        return;
                    }
                }
                count++;
                i = t;
            }else{
                count++;
            }
        }
        System.out.println(count+1);
    }
}
