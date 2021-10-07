package shengce;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/10/7 8:10 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int m = in.nextInt();
        System.out.println(getTimes(new BigInteger(String.valueOf(x)),new BigInteger(String.valueOf(y)),new BigInteger(String.valueOf(m))));
    }

    private static int getTimes(BigInteger x, BigInteger y, BigInteger m) {
        int times = 0;
        if (x.compareTo(m) < 0 && y.compareTo(m) < 0){
            while (x.compareTo(m) < 0 && y.compareTo(m) < 0){
                BigInteger count = x.add(y);
                if (count.compareTo(new BigInteger("0")) <= 0){
                    return -1;
                }
                times++;
                if (x.compareTo(y) < 0){
                    x = count;
                }else{
                    y = count;
                }
            }
        }

        return times;

    }
}
