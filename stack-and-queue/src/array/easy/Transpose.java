package array.easy;

/**
 * @Description: 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * @Author: lmwis
 * @Date 2021-02-25 15:14
 * @Version 1.0
 */
public class Transpose {
    // ?
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int length = matrix[0].length;
        int[][] res = new int[length][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<length;j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
