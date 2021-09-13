package tongcheng;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/11 8:51 下午
 * @Version: 1.0
 */
public class Q3 {

    public int getTeams (int[] heros) {
        // write code here
        int[] map = new int[5];
        for (int i = 0; i < heros.length; i++) {
            map[heros[i]]++;
        }
        int res = 1;
        for (int i = 0; i < map.length; i++) {
            res*=map[i];
        }
        return res;
    }
}
