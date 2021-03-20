package meituan;

import java.util.Scanner;

/**
 * @Description:
 * abcdefghijklmnopqrstuvwxyz
 * meituan
 * @Author: lmwis
 * @Date 2021-03-20 15:55
 * @Version 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

            String seq = input.nextLine();
            String target = input.nextLine();
            System.out.println(function(seq,target));

    }

    public static int function(String seq,String target){
        seq = seq.trim();
        target = target.trim();
        int sum=0;
        String currentStr=seq;
        for(int i=0;i<target.length();){
            int index = currentStr.indexOf(target.charAt(i));
            if(index!=-1){
                // 截取后部分
                currentStr = currentStr.substring(index+1);
                sum+=index;
                i++;
            }else{
                currentStr = currentStr.concat(seq);
            }
        }
        return sum;
    }
}
