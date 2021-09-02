package kedaxunfei;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/8/28 7:25 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] score = new Integer[50];
        for (int i = 0; i < 50; i++) {
            score[i] = in.nextInt();
        }

        int target = in.nextInt();
        for (int i = 0; i < score.length; i++) {
            if(target == score[i]){
                System.out.println(method(i+1));
            }
        }
    }
    public static String method(int pos){
        if (pos<=5){
            return "A+";
        }else if(pos<=15){
            return "A0";
        }else if(pos<=30){
            return "B+";
        }else if(pos<=35){
            return "B0";
        }else if(pos<=45){
            return "C+";
        }else if(pos<=48){
            return "C0";
        }
        return "F";
    }
}
