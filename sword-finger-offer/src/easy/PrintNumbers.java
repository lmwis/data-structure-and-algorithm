package easy;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/6/18 12:03 下午
 * @Version: 1.0
 */
public class PrintNumbers {
    public static void main(String[] args) {
        Arrays.stream(new PrintNumbers().printNumbers(2)).forEach(System.out::println);
    }
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10,n)-1;
        int[] res = new int[max];
        for(int k=0;k<max;k++){
            res[k] = k+1;
        }
        return res;
    }
}
