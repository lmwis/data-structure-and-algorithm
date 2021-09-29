package tencent;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/26 9:33 下午
 * @Version: 1.0
 */
public class Q3 {
    static final String P1 = "\\+";
    static final String P2 = "\\*";
    static final String P3 = "@";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(method(s));
    }

    private static int method(String s) {
        System.out.println(P1);
        String[] split = s.split("");
        for (String s1 : split) {
            String[] split1 = s1.split(P2);
            for (String s2 : split1) {
                String[] split2 = s2.split(P3);
                for (String s3 : split2) {
                    System.out.println(s3);
                }
            }
        }
//        int sum=0;
//        while(s.length()>0){
//            int i = s.indexOf(P3);
//            if (i>=0){
//                String temp = s.substring(i,i+3);
//                int a = new Integer(temp.substring(0,1));
//                int b = new Integer(temp.substring(2,3));
//                int tempCount =a | (a+b);
//                s = s.replaceAll(temp,tempCount+"");
//            }
//        }
        return 0;
    }
}
