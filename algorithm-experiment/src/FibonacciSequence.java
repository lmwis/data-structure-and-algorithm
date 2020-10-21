import java.util.Scanner;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-21 20:07
 * @Version 1.0
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(dep(n));
    }

    public static long dep(int  n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==3){
            return 3;
        }else{
            return dep(n-1)+dep(n-2)+dep(n-3);
        }
    }
}
