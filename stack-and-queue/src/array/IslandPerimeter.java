package array;

/**
 * @Description: 463 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * 输出: 16
 * @Author: lmwis
 * @Date 2020-10-30 10:11
 * @Version 1.0
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
//        int sum = islandPerimeter.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
        int sum = islandPerimeter.islandPerimeterDFS(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});
        System.out.println(sum);
    }

    /**
     * 暴力法 遍历到每个1加算作4个边，然后一个方向有几个重复的减几
     * @param grid
     * @return
     */
    int islandPerimeter(int[][] grid) {
        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    sum+=4;
                    if(i-1>=0){
                        if(grid[i-1][j]==1){
                            sum--;
                        }
                    }
                    if(i+1<grid.length){
                        if(grid[i+1][j]==1){
                            sum--;
                        }
                    }
                    if(j-1>=0){
                        if(grid[i][j-1]==1){
                            sum--;
                        }
                    }
                    if(j+1<grid[0].length){
                        if(grid[i][j+1]==1){
                            sum--;
                        }
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 使用DFS遍历(性能还不如全遍历？)
     * @param grid
     * @return
     */
    int islandPerimeterDFS(int[][] grid){
        // 找入口
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] grid,int i,int j){

        // 和边界相邻
        if(i<0 || j<0 || i>=grid.length||j>=grid[0].length){
            return 1;
        }
        // 和水域相邻
        if(grid[i][j]==0){
            return 1;
        }
        // 和遍历过的岛屿相邻
        if(grid[i][j]!=1){
            return 0;
        }
        // 遍历到当前岛屿，赋值为2，防止再次遍历
        grid[i][j]=2;
        return dfs(grid,i+1,j)
                +dfs(grid,i-1,j)
                +dfs(grid,i,j+1)
                +dfs(grid,i,j-1);
    }
}
