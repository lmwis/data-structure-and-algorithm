package kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/8/28 7:37 下午
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int st = in.nextInt();
            res[i] = method(x,st);
        }
        Arrays.stream(res).forEach(System.out::println);
    }

    public static double method(int x, int st) {
        double res = 0;
        int left = x+1;
        int right =  61-x;
        if(right>left){
            res = 1-Math.pow(0.5,right);
        }else {
            res = 1-Math.pow(0.5,left);
        }
        return res;
    }
}
