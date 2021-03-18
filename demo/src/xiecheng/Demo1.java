package xiecheng;

import java.util.Scanner;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-18 18:34
 * @Version 1.0
 */
public class Demo1 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt()){
            double n = (double)input.nextInt();
            int m = input.nextInt();
            double sum=n;
            for(int i=m-1;i>0;i--){
                n = Math.sqrt(n);
                sum+=n;
                System.out.println(n);
            }
            System.out.println(String.format("%.2f", sum));
        }
    }

}
