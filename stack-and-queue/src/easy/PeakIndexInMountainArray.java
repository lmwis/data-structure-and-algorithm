package easy;

/**
 * @Description: 852. 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * 输入：arr = [0,1,0]
 * 输出：1
 *
 * 输入：arr = [0,2,1,0]
 * 输出：1
 *
 * @Author: lmwis
 * @Data: 2021/6/15 11:46 上午
 * @Version: 1.0
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        new PeakIndexInMountainArray().peakIndexInMountainArray(new int[]{0,1,0});
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int cur = (left+right)/2;
            if(arr[cur]>arr[cur+1]&&arr[cur]>arr[cur-1]){
                return cur;
            }else{
                if(arr[cur]>arr[cur+1]){
                    right = cur;
                }else{
                    left = cur;
                }
            }
        }
        return 0;
    }
}
