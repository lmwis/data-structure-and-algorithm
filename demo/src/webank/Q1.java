package webank;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/10/23 2:58 下午
 * @Version: 1.0
 */
public class Q1 {
    static Calendar instance = Calendar.getInstance();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if (a==b){
            int res = 0;
            for (int j = 1; j <= 12; j++) {
                instance.set(a,j-1,1);
                int temp = instance.get(Calendar.DAY_OF_WEEK)-1;
                if (temp==1){
                    res++;
                }
            }
            System.out.println(res);
            return;
        }
        int res = 0;
        for (int i = a; i <=b; i++) {
            for (int j = 0; j < 12; j++) {
                instance.set(i,j,1);
                int temp = instance.get(Calendar.DAY_OF_WEEK)-1;
                if (temp==1){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
