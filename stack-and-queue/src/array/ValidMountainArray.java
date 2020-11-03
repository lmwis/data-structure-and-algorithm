package array;

/**
 * @Description: 941.有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 *      A[0] < A[1] < ... A[i-1] < A[i]
 *      A[i] > A[i+1] > ... > A[A.length - 1]
 * @Author: lmwis
 * @Date 2020-11-03 11:47
 * @Version 1.0
 */
public class ValidMountainArray {
    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        validMountainArray.validMountainArray(new int[]{0,3,2,1});
    }

    public boolean validMountainArray(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        //从左边往右边找，一直找到山峰为止
        while (left + 1 < len && A[left] < A[left + 1])
            left++;
        //从右边往左边找，一直找到山峰为止
        while (right > 0 && A[right - 1] > A[right])
            right--;
        //判断从左边和从右边找的山峰是不是同一个
        return left > 0 && right < len - 1 && left == right;
    }
}
