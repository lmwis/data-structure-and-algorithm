/**
 * @Description: 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @Author: lmwis
 * @Date 2020-12-03 21:14
 * @Version 1.0
 */
public class CountPrimes {

    // Eeatosthese筛法，每次除去非质数的整数倍
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int count = 0;
        int[] container = new int[n];
        for(int i=2;i<n;i++){

            if(container[i]!=1){
                count++;
                for(int j=i+i;j<n;j+=i){
                    container[j]=1;
                }
            }
        }
        return count;
    }
}
