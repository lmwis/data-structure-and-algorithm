package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/8/28 4:30 下午
 * @Version: 1.0
 */
public class G3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int sq = n*m;
        int[] mo = new int[sq];
        for(int i = 0; i < sq; i++){
            mo[i] = in.nextInt();
        }

        int q = in.nextInt();
        int[] res = new int[q];
        for(int i = 0; i < q; i++){
            res[i] = new G3().method(n,m,mo,in.nextInt());
        }

        Arrays.stream(res).forEach(System.out::println);
    }

    private  int method(int n, int m, int[] mo, int i) {
        int res = 0;
        return res;
    }
}
