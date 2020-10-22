import java.util.Scanner;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-21 20:23
 * @Version 1.0
 */
public class Hanoi {
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dep(n,1,2,3);
        System.out.println(count);
    }
    public static void dep(int n,int p1,int p2,int p3){
        if(n==1) {
            count++;
        }else{
            dep(n-1,p1,p3,p2);
            count++;
            dep(n-1,p2,p1,p3);
        }
    }
}
