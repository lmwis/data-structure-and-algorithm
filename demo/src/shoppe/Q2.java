package shoppe;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/7/5 3:37 下午
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        q2.minimumInitHealth(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}},new int[]{0,0},new int[]{2,2});
        System.out.println(q2.ans);
    }
    int ans = 1000000000;
    int help = 0;
    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        // write code here
        int[][] fow = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] v = new boolean[rooms.length][rooms[0].length];
        dfs(fow,v,new int[]{0,0},rooms,endPoint,1,1-rooms[startPoint[0]][startPoint[1]]);
        return help;
    }

    public int dfs(int[][] fow,boolean[][] v,int[] pos,int[][] rooms,int[] endPoint,int health,int help){
        if(pos[0] == endPoint[0] && pos[1] == endPoint[1]){
            ans = Math.min(ans,help);
            return health;
        }
        if(v[pos[0]][pos[1]]){
            ans = Math.min(ans,help);
            return health;
        }

        for(int i=0;i<4;i++){
            int x = fow[i][0]+pos[0];
            int y = fow[i][1]+pos[1];
            if(x<0 || y<0 || x>=rooms.length || y>=rooms[0].length){
                continue;
            }
            health+=rooms[x][y];
            pos[0] = x;
            pos[1] = y;
            v[x][y] = true;
            if(health>0){
                dfs(fow, v, pos, rooms, endPoint,health,help);
                health -=rooms[x][y];
            }else{
                help = help-health+1;
                dfs(fow, v, pos, rooms, endPoint,health,help);
                help -= help -1 +health;
            }
            v[x][y] = false;
        }
        return 0;
    }

}
