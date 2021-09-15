package jinshanyun;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description:
 * 现在给你N个正整数，从中选取3个数字的和，刚好能够组成M的倍数。请问存在多少种不同的选取方案？
 * 相同的一组数如果次序不同只能算做一种方案，不同位置的相同数字需当做同一个数字看待。
 * 例如一组数字[2,3,3,4]，从中选取3个数字的和来组成3的倍数，只存在一种方案(2,3,4)。
 * @Author: lmwis
 * @Data: 2021/9/15 7:40 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(set::add);
        int nn = set.size();
        int[] nArr = new int[nn];
        int i = 0;
        for (Integer integer : set) {
            nArr[i++] = integer;
        }
        int count=0;
        for (int j = 0; j < nn; j++) {
            for (int k = j+1; k < nn; k++) {
                for (int l = k+1; l < nn; l++) {
                  if ((nArr[j]+nArr[k]+nArr[l])%m==0){
                      count++;
                  }
                }
            }
        }
        System.out.println(count);
    }

}
