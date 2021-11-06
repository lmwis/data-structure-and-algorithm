/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/11/4 10:02 上午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        System.out.println(new Q1().fib(0));
        System.out.println(new Q1().fib(1));
        System.out.println(new Q1().fib(2));
        System.out.println(new Q1().fib(3));
        System.out.println(new Q1().fib(4));
        System.out.println(new Q1().fib(5));
        System.out.println(new Q1().fib(6));
    }
    public int fib(int n){
        if (n<=1){
            return 1;
        }

        int a = 1;
        int b = 1;
        int ans = 0;
        for (int i = 2; i <=n; i++) {
            ans = a+b;
            a = b;
            b = ans;
        }
        return ans;
    }
}
