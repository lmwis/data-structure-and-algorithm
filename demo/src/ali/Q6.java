package ali;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/7/25 8:39 下午
 * @Version: 1.0
 */
public class Q6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            arr[i] = in.nextInt();
        }
        method(arr);
//        System.out.println(new BigInteger("0").compareTo(new BigInteger("010"))>=0);
//        System.out.println(new BigInteger("010").toString());
    }

    public static void method(int[] arr){
        long num1 = 0;
        long num2 = 0;
        String num1Str = "";
        String num2Str = "";
        for(int i=9;i>=0;i--){
            while(arr[i]>0){
                if(new BigInteger(num1Str.length()>0?num1Str:"0").compareTo(new BigInteger(num2Str.length()>0?num2Str:"0"))<=0){
                    num1Str = num1Str+""+i;
                    //num1 = Long.parseLong(temp);
                }else{
                    num2Str = num2Str+""+i;
                    //num2 = Long.parseLong(temp);
                }
                arr[i]--;
            }
        }
        System.out.println(new BigInteger(num1Str.length()>0?num1Str:"0").multiply(new BigInteger(num2Str.length()>0?num2Str:"0")));
    }
}
