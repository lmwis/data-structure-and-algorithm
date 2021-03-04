package sort;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * 时间：
 *  平均：O(n^2)
 *  最好：O(n)
 *  最坏：O(n^2)
 * 空间：O(1)
 * 稳定
 * @Author: lmwis
 * @Date 2021-03-04 22:45
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{8,4,7,2,4,7};
        System.out.println(Arrays.toString(array));
        for(int i=1;i<array.length;i++){
            int value = array[i];
            int index = i-1;
            while(index>=0 && array[index]>value){
                array[index+1] = array[index];
                index--;
            }
            array[index+1] = value;
            System.out.println(Arrays.toString(array));
        }

    }
}
