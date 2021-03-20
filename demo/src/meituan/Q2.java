package meituan;

import java.util.*;

/**
 * 时间限制： 3000MS
 * 内存限制： 786432KB
 * 题目描述：
 * 小团现在有两个等大的多重集合（与集合的区别仅是在可以在集合中出现重复元素）A 和 B。她现在想让 A 集合与 B 集合相等。她会先选择一个非负整数 x，然后让 A 集合中的所有数都加上 x 并对 m 取模。也就是说，对于 A 中的全部元素 a，都把 a 变成 (a + x) mod m。
 *
 * 她想知道这个最小的 x 是多少，才能使经过变换后 A = B。并且她保证至少存在一个满足条件的 x。
 * 输入描述
 * 第一行两个正整数 n, m，n 表示 A, B 两集合分别有 n 个元素；
 *
 * 第二行 n 个非负整数 ai，表示 A 多重集。
 *
 * 第三行 n 个非负整数 bi，表示 B 多重集。
 *
 * 1 ≤ n ≤ 2000, 1 ≤ m ≤ 109, 0 ≤ ai , bi < m。
 *
 * 输出描述
 * 输出一个非负整数，表示最小的 x 值。
 *
 *
 * 样例输入
 * 6 8
 * 1 1 4 5 1 4
 * 3 0 4 0 3 0
 * 样例输出
 * 7
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-20 16:22
 * @Version 1.0
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
//        int[] A = new int[n];
//        int[] B = new int[n];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < n; i++) {
//            A[i] = ;
            setA.add(input.nextInt());
        }
        for (int i = 0; i < n; i++) {
//            B[i] = input.nextInt();
            setB.add(input.nextInt());
        }

        System.out.println(function(setA, setB, m));

    }

    public static int function(Set<Integer> A, Set<Integer> B, int m) {
        Iterator<Integer> iterator = A.iterator();
        int[] arrA = new int[A.size()];
        int[] arrB = new int[A.size()];
        int[][] arr = new int[A.size()][B.size()];

        int count=0;
        while(iterator.hasNext()){
            int keyA = iterator.next();
            arrA[count] = keyA;
            count++;
        }
        count=0;
        Iterator<Integer> iteratorB = B.iterator();
        while(iteratorB.hasNext()){
            int keyB = iteratorB.next();
            arrB[count] = keyB;
            count++;
        }
//        System.out.println(Arrays.toString(arrA));
//        System.out.println(Arrays.toString(arrB));
        for(int i=0;i<arrA.length;i++){
            for(int j=0;j<arrB.length;j++){
                arr[i][j] = arrA[i]-arrB[j];
            }
        }
        Arrays.sort(arr[0]);
        int exp = arr[0][arrB.length-1];

        System.out.println("===="+exp);
        for(int i=0;i<arrA.length;i++){
            Arrays.sort(arr[i]);
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));
        return m-(exp%m);
//        return 0;
    }

}
