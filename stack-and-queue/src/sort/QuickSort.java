package sort;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @Author: lmwis
 * @Date 2021-03-05 14:47
 * @Version 1.0
 */
public class QuickSort {

    void quickSort(int[] array,int left,int right){
        if(left>right){
            return;
        }
        if(right-left<=1){
            if(array[right]<array[left]){
//                int temp = array[left];
//                array[left] = array[right];
//                array[right] = temp;
                array[left] = array[left]^array[right];
                array[right] = array[right]^array[left];
                array[left] = array[left]^array[right];
            }
            return;
        }
        int defaultLeft = left;
        int defaultRight = right;
        // 选中间这个点为基准也可以，最重要的是左右指针碰撞后要跟基准换位
        // 因为左指针扫过的都比基准小
        // 右指针扫过的比基准大
        int pivot = (right+left)/2;
        int value = array[pivot];

        while(left<right && left!=pivot && right!=pivot){
            if(array[left]>=value && array[right]<=value){
                // 交换
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
            if(array[left]<value){
                left++;
            }
            if(array[right]>value){
                right--;
            }
        }
        int newPivot = left==pivot?right:left;
        // 跟基准换位
        array[pivot] = array[newPivot];
        array[newPivot] = value;
        System.out.println("=:"+Arrays.toString(array));
        // 递归
        // 向左
        quickSort(array,defaultLeft,newPivot-1);
        // 向右
        quickSort(array,newPivot+1,defaultRight);
    }


    public static void main(String[] args) {
//        int[] array = new int[]{8,9,7,2,4,1,2};
        int[] array = new int[]{8,4,7,2,4,7};
        System.out.println(Arrays.toString(array));
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
