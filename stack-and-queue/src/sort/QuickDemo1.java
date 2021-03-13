package sort;

import java.util.Arrays;

/**
 * @Description: quick test
 * @Author: lmwis
 * @Date 2021-03-13 18:37
 * @Version 1.0
 */
public class QuickDemo1 {

    public void quickSort(int arr[],int left,int right){

        if(left>=right){
            return;
        }
        if(right-left<=1){
            if(arr[left]>arr[right]){
                swap(arr,left,right);
            }
            return;
        }
        int defaultLeft = left;
        int defaultRight = right;
        int pivot = (left+right)/2;
        int value = arr[pivot];
        while(left<right && left!=pivot && right!=pivot){
            if(arr[left]>=value&&arr[right]<=value){
                swap(arr,left,right);
                left++;
                right--;
            }

            if(arr[left]<value){
                left++;
            }
            if(arr[right]>value){
                right--;
            }
        }

        int newPivot = left==pivot?right:left;
        swap(arr, pivot, newPivot);
        System.out.println("=:"+Arrays.toString(arr));
        quickSort(arr,defaultLeft,newPivot-1);
        quickSort(arr,newPivot+1,defaultRight);

    }

    private void swap(int[] arr, int left, int right) {
        arr[left] = arr[left]^arr[right];
        arr[right] = arr[right]^arr[left];
        arr[left] = arr[left]^arr[right];
    }


    public static void main(String[] args) {
        int[] array = new int[]{8,4,7,2,4,7};
        System.out.println(Arrays.toString(array));
        QuickDemo1 quickSort = new QuickDemo1();
        quickSort.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
