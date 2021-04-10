package wangyi;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-04-10 15:53
 * @Version 1.0
 */
public class Q4 {

    public static void main(String[] args) {
        System.out.println(new Q4().GetBestWarehouseLocate(new int[][]{{0,1,3},{1,2,2}},3));
    }

    public int GetBestWarehouseLocate (int[][] distancePairs, int CityNum) {
        int[][] dis = new int[CityNum][CityNum];
        for(int i=0;i<distancePairs.length;i++){
            dis[distancePairs[i][0]][distancePairs[i][1]] += distancePairs[i][2];
            dis[distancePairs[i][1]][distancePairs[i][0]] += distancePairs[i][2];
        }

        int[] total = new int[CityNum];
        for(int i=0;i<dis.length;i++){
            for(int j=0;j<dis[i].length;j++){
                total[i]+=dis[i][j];
            }
        }
        int minIndex = 0;
        for(int i=1;i<total.length;i++){
            if(total[i]<total[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
        // write code here
    }
}
