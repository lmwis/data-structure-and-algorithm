package sort;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * 时间：
 *  平均：O(n^2)
 *  最好：O(n^2)
 *  最坏：O(n^2)
 * 空间：O(1)
 * 不稳定
 * @Author: lmwis
 * @Date 2021-03-04 22:35
 * @Version 1.0
 */
public class SelectSort {
    public static void main(String[] args){
        int[] array = new int[]{8,4,7,2,4,7};
        System.out.println(Arrays.toString(array));
        for(int i=0;i<array.length;i++){
            int index = i;
            for(int j=i+1;j<array.length;j++){
                if(array[index]>=array[j]){
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
            System.out.println(Arrays.toString(array));
        }

    }
}
