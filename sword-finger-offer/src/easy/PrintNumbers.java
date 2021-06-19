package easy;

import java.util.Arrays;

/**
 * @Description: 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
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
