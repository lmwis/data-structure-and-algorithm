package array.easy;

/**
 * @Description: 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * @Author: lmwis
 * @Date 2021-02-22 18:22
 * @Version 1.0
 */
public class IisToeplitzMatrix {
    /**
     * 根据定义，当且仅当矩阵中每个元素都与其左上角相邻的元素（如果存在）相等时，该矩阵为托普利茨矩阵。
     * 因此，我们遍历该矩阵，将每一个元素和它左上角的元素相比对即可。
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length;
        int weight = matrix[0].length;
        for(int i=1;i<height;i++){
            for(int j=1;j<weight;j++){
                if(matrix[i][j]!=matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
