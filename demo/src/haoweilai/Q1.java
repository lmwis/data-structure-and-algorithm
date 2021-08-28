package haoweilai;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/8/23 8:16 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        new Q1().minPathSum(new int[][]{{3,1,0,2},{4,3,2,1},{5,2,1,0},{1,2,3,4},{0,0,0,1}});
    }
    public int minPathSum (int[][] nm) {
        // write code here
        int res = 0;
        int i=0;
        int j=0;
        System.out.println(nm.length);
        System.out.println(nm[0].length);
        while(i<nm.length&&j<nm[0].length){
            if(i==nm.length-1&&j==nm[0].length-1){
                res+=nm[i][j];
                break;
            }
            if(j==nm[0].length-1){
                res+=nm[i+1][j];
                i++;
                continue;
            }
            if(i==nm.length-1){
                res+=nm[i][j+1];
                j++;
                continue;
            }
            if(nm[i][j+1]>=nm[i+1][j]){
                res +=nm[i][j+1];
                j++;
            }else{
                res +=nm[i+1][j];
                i++;
            }
        }
        return res;

    }
}
