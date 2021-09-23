package wxg;

import java.util.Scanner;

/**
 * @Description:
 * 面试题目，请勿外泄。
 *
 * 注：进阶部分不一定要实现。
 * 为了提高效率，可以在个人本地电脑的编译器上验证代码，并把解题代码和验证代码都贴上来。
 *
 *
 * 1.对于一棵满二叉搜索树深度为K，节点数为 2^K - 1 ；节点值为 1至 (2^K-1)。
 * 给出K和任意三个节点的值，输出包含该三个节点的最小子树的根节点值
 * 样例输入：4 10 15 13
 * 样例输出：12
 *
 * 注：K=3的例子如下
 *           4
 *    2          6
 * 1    3   5     7
 *
 *
 *
 * @Author: lmwis
 * @Data: 2021/9/22 8:50 下午
 * @Version: 1.0
 */
public class Q11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        if(k<=2){
            System.out.println(k);
            return;
        }

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int min = Math.min(a,Math.min(b,c));
        int max = Math.max(a,Math.max(b,c));

        int left = 1;
        int right = (int)Math.pow(2, k) - 1;
        int root = (left + right) / 2;

        for (;;){
            // 在两侧为正确答案
            if(root > min && root < max){
                break;
            }
            // 小于最小值向右搜索
            if(root < min){
                left = root + 1;
                root = (left + right) / 2; // 找到root
            }else if(root > max){ // 大于最大值向左搜索
                right = root - 1;
                root = (left + right) / 2; // root
            }
        }

        System.out.println(root);
    }
}
