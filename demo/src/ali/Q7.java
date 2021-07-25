package ali;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/7/25 8:59 下午
 * @Version: 1.0
 */
public class Q7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i] = in.nextInt();
        }
        int[] arr2 = new int[n];
        for(int i=0;i<n;i++){
            arr2[i] = in.nextInt();
        }
        method(arr1,arr2,n);

    }

    public static void method(int[] arr1,int[] arr2,int n){
        int res1=0;
        int res2=0;
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        int i=0;
        int j=0;
        for(;;){
            if(i>=(n-1)&&j>=(n-1)){
                break;
            }
            if(i<n){
                if(set.contains(arr1[i])){
                    res1++;
                    boolean flag = true;
                    while(flag){
                        res1++;
                        if(stack.pop() == arr1[i]){
                            flag = false;
                        }
                    }
                }else{
                    stack.push(arr1[i]);
                    set.add(arr1[i]);
                }
                i++;
            }
            if(j<n){
                if(set.contains(arr2[j])){
                    res2++;
                    boolean flag = true;
                    while(flag){
                        res2++;
                        if(stack.pop() == arr2[j]){
                            flag = false;
                        }
                    }
                }else{
                    stack.push(arr2[j]);
                    set.add(arr2[j]);
                }
                j++;
            }

        }
        System.out.println(res1+" "+res2);
    }
}
