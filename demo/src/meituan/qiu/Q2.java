package meituan.qiu;

import java.util.*;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/11 4:30 下午
 * @Version: 1.0
 */
public class Q2 {

    /**
     * 55
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int m  = in.nextInt();
        int q  = in.nextInt();
        SortedMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(Integer::compareTo);
        for (int i = 1; i <= n; i++) {
            sortedMap.put(i,0);
        }
        for (int i = 0; i < m*2; i++) {
            int any = in.nextInt();
            Integer orDefault = sortedMap.getOrDefault(any, 0);
            orDefault++;
            sortedMap.put(any,orDefault);
        }
        for (int i = 0; i < q; i++) {
            int q1 = in.nextInt();
            int q2 = in.nextInt();
            Integer d1 = sortedMap.get(q1);
            Integer d2 = sortedMap.get(q2);
            sortedMap.put(q1,d2);
            sortedMap.put(q2,d1);
        }

        sortedMap.forEach((a, b)->{
            System.out.print(b+" ");
        });
//        System.out.println(new Q1().method(str,str.length()));
    }
}
