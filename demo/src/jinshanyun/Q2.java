package jinshanyun;

import java.util.*;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/15 8:15 下午
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
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
        // 去重完 nArr
        int count=0;
        for (int m = 1; m <=n ; m++) {
            count+=getCount(nArr,m);
        }
    }
    List<List<Integer>> total = new ArrayList<>();
    private static int getCount(int[] nArr, int m,List<Integer> curList) {
         if (m==0){

         }
    }
}
