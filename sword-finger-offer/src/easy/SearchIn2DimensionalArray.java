package easy;

import java.util.Arrays;

/**
 * @Description: 二维数组中的查找
 * @Author: lmwis
 * @Date 2020-10-20 21:04
 * @Version 1.0
 */
public class SearchIn2DimensionalArray {
    public static void main(String[] args) {
        SearchIn2DimensionalArray searchIn2DimensionalArray = new SearchIn2DimensionalArray();
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchIn2DimensionalArray.findNumberIn2DArray(matrix,5));
    }

    /**
     * 从右上角开始查找
     *  如果当前元素大于目标值，则下面的所有元素都大于目标值，则应该往左查找
     *  如果当前元素小于目标值，则左边的所有元素都小于目标值，则应该往下查找
     *
     *  执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     *  内存消耗：44 MB, 在所有 Java 提交中击败了97.72%的用户
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        Arrays.stream(matrix).forEach(System.out::print);
        int n = matrix.length;
        int m = matrix[0].length;
        if(n==0){
            return false;
        }
        int i = n-1;
        int j=0;
        while(i>=0  && j<m){
            int num = matrix[i][j];
            if(num>target){
                i--;
            }else if(num<target){
                j++;
            }else if(num==target){
                return true;
            }
        }
        return false;
    }
}
