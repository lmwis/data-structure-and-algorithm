package meituan.qiu;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/11 4:04 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(new Q1().method(str,str.length()));
    }

    /**
     * 小于22肯定不能被整除
     * 36
     * @param str
     * @return
     */
    private int method(String str,int n) {
        if (n==0) return 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cur = new Integer(str.substring(i,j+1));
                if(cur%22==0){
                    count++;
                }
            }
        }
        return count;
    }
}
