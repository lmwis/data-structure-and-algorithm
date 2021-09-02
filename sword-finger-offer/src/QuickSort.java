import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/8/28 11:32 上午
 * @Version: 1.0
 */
public class QuickSort {
    void quickSort(int[] array,int left,int right){
        // 表示只有一个数，递归终止
        if(left>right){
            return;
        }
        // 小优化，当一组只剩两个数时直接进行比较交换
        if(right-left<=1){
            if(array[right]<array[left]){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            return;
        }
        int defaultLeft = left;
        int defaultRight = right;
        // 选中间这个点为基准也可以，最重要的是左右指针碰撞后要跟基准换位
        // 一开始傻逼取得右减左除2
        int pivot = (right+left)/2;
        int value = array[pivot];

        while(left<right && left!=pivot && right!=pivot){
            // 对 相等也要交换
            if(array[left]>=value && array[right]<=value){
                // 交换
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                // 这里往前走一步是因为相等交换会造成拿着一个和基准一样的数反复横跳进入死循环
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
        // 定新基准
        // 因为左指针扫过的都比基准小，所以左指针碰撞了右指针没有说明右右指针的数小于基准，应该交换
        // 简单说就是谁撞到基准，另外一边跟基准交换，成为新基准
        int newPivot = left==pivot?right:left;
        // 跟基准换位
        array[pivot] = array[newPivot];
        array[newPivot] = value;
        System.out.println("=:"+ Arrays.toString(array));
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
