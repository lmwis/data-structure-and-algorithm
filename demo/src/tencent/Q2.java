package tencent;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/26 8:55 下午
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Arrays.stream(findMaxIndex(new int[]{7, 3, 1, 2, 3})).forEach(System.out::println); // 0 1 4 3 2
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//
//        int[] res = new int[t];
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            for (int j = 0; j < n; j++) {
//                arr[j] = in.nextInt();
//            }
//            res[i] = method(arr,findMaxIndex(arr));
//        }
//        Arrays.stream(res).forEach(System.out::println);
    }
    private static int[] findMaxIndex(int[] arr){
//        int max=0;
//        int p=0;
        Integer[] old = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            old[i] = arr[i];
        }

        Arrays.sort(old, new  Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (old[i]==arr[j]){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
    private static int method(int[] arr,int p) {
        int max=0;
        for (int j = p; j < arr.length; j++) {
            int i = j;
            int cur = arr[i];
            int total = cur;
            while(true){
                i += cur;
                if (i>arr.length-1){
                    break;
                }
                cur = arr[i];
                total+=cur;
            }
            max = Math.max(total,max);
        }
        return max;
    }
}
