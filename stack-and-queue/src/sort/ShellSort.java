package sort;

import java.util.Arrays;

/**
 * @Description: 希尔排序  优化过的插入排序
 * 时间：
 *  平均：O(n3/2)
 *  最好：O(n)
 *  最坏：O(n^2)
 * 空间：O(1)
 * 不稳定
 * @Author: lmwis
 * @Date 2021-03-04 23:15
 * @Version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{8,6,7,2,4,5};
        System.out.println(Arrays.toString(array));
        for(int grep = array.length/2;grep>0;grep/=2){ // 步长 3 1
            for(int i=grep;i<array.length;i++){ // 0 3 | 1 4 | 2 5 | (8,2) /  2 4 6 | 1 3 5
                int value = array[i];
                int index = i-grep;
                // 采用移动法
                while(index>=0 && array[index]>value){
                    array[index+grep] = array[index];
                    index -=grep;
                }
                array[index+grep] = value;
            }
            System.out.println(Arrays.toString(array));
        }


    }
}
