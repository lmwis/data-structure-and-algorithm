package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 给定一个包含n个整数的数组A，找到数组中包含的所有三元组（a,b,c）a<=b<=c, 使得a+b+c = 0
 * 输入：{-1 0 1 2 -1 -4}
 * 输出：{-1 0 1},{-1 -1 2}
 * @Author: lmwis
 * @Data: 2021/8/19 5:47 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {

        new Q1().solution(new int[]{-1,0,1,2,-1,-4}).forEach(k->{
            k.forEach(k1->{
                System.out.print(k+" ");
            });
            System.out.println();
        });
    }

    /**
     * a_b_c
     * b=x and c=x
     *
     * @param arr
     * @return
     */
    public List<List<Integer>> solution(int[] arr) {
        if(arr.length<3) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        //  [-4,-1,-1,0,1,2]
        int i = 0;
        int j = arr.length / 2;
        int k = arr.length-1;
        while (i < k) {
            while (i < j && j < k) {
                if (arr[i] + arr[j] + arr[k] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    res.add(temp);
                } else {
                    if (arr[j] + arr[k] > 0) {
                        j--;
                    } else {
                        j++;
                    }
                }
            }
            if(i==j){
                k--;
            }else{
                i++;
            }
            j = (i+k)/2;
        }
        return res;

//        for(int i=0;i<arr.length;i++){
//        }
    }
}
