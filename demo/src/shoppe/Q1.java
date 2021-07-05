package shoppe;

/**
 * @Description:
 * 手上有 n 朵花，每朵的花瓣数保存在一个数组中。
 * 我们每次可以选择任意一朵，拿走其中的一瓣或者两瓣，求掰完所有花的最少次数。
 * @Author: lmwis
 * @Data: 2021/7/5 3:24 下午
 * @Version: 1.0
 */
public class Q1 {
    public int petalsBreak(int[] petals) {
        // write code here
        int count=0;
        for(int i=0;i<petals.length;i++){
            count += (petals[i]+1)/2;
        }
        return count;
    }
}
