package sort;

/**
 * @Description: 快速排序
 * @Author: lmwis
 * @Date 2021-03-05 14:47
 * @Version 1.0
 */
public class QuickSort {

    void quickSort(int[] array,int left,int right){
        int pivot = (right-left)/2;
        int value = array[pivot];

        while(left>=right){
            if(array[left]<value){
                left++;
            }
            if(array[right]>value){
                right--;
            }
            if(array[left]>value && array[right]<value){
                // 交换
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            } 
        }

    }


    public static void main(String[] args) {

    }

}
