package easy;

/**
 * @Description: 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 11111111111111111111111111111101 // 超出了有符号int的值，因此需要>>>作无符号右移
 *
 *
 * @Author: lmwis
 * @Data: 2021/6/15 12:28 下午
 * @Version: 1.0
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            res+=n&1;
            n = n>>>1 ; // 无符号右移
        }
        return res;
    }
    public int hammingWeightPlus(int n) {
        int res=0;
        while(n!=0){
            res++;
            n=n&(n-1); // 将n最右边的1变成0，因此循环次数为n中1的次数
        }
        return res;
    }
}
