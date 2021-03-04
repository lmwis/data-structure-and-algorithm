package medium;

/**
 * @Description: 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * @Author: lmwis
 * @Date 2021-03-04 12:02
 * @Version 1.0
 */
public class Exist {
    /**
     * 思路：深度优先搜索（DFS）+ 剪枝
     * FS 解析：
     * 递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
     * 终止条件：
     * 返回 falsefalse ： (1) 行或列索引越界 或 (2) 当前矩阵元素与目标字符不同 或 (3) 当前矩阵元素已访问过 （ (3) 可合并至 (2) ） 。
     * 返回 truetrue ： k = len(word) - 1 ，即字符串 word 已全部匹配。
     * 递推工作：
     * 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问。
     * 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
     * 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
     * 返回值： 返回布尔量 res ，代表是否搜索到目标字符串。
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word,int i,int j, int k){
        // 索引越界
        if(i<0||i>=board.length||j<0||j>=board[0].length){
            return false;
        }
        // 已访问过
        if(board[i][j]=='1'){
            return false;
        }
        // 不符合目标字符串
        if(board[i][j]!=word.charAt(k)){
            return false;
        }
        if(k==word.length()-1){
            return true;
        }
        k++;
        char temp = board[i][j];
        board[i][j]='1';
        boolean res = dfs(board,word,i+1,j,k) || dfs(board,word,i,j+1,k)||dfs(board,word,i-1,j,k)||dfs(board,word,i,j-1,k);
        // 回溯
        board[i][j] = temp;
        return res;
    }
}
