package shengce;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/10/7 8:29 下午
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        int count=0;
            if (nums/100>0){
                count+=nums/100;
                nums = nums%100;
            }
            if (nums/20>0){
                count+=nums/20;
                nums = nums%20;
            }
            if (nums/10>0){
                count+=nums/10;
                nums = nums%10;
            }
            if (nums/5>0){
                count+=nums/5;
                nums = nums%5;
            }
            if (nums>0){
                count+=nums;
            }
        System.out.println(count);
    }
}
