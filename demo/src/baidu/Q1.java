package baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-30 19:52
 * @Version 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String nums = in.next();
        int[] numArr = new int[N];
        for(int i=0;i<nums.length();i++){
            numArr[i] = nums.charAt(i)-48;
        }
        int[] dp = new int[N]; // 到第i个位置最少要多少步
        dp[0]=0;
        int []mp = new int[10];
        for (int i = 0; i < 10; ++i) {
            mp[i] = -1;
        }
        Map<Integer,Integer> maps = new HashMap<>();
        for(int i=0;i<10;i++){
            maps.put(i,-1);
        }
        maps.replace(numArr[0],0);
        // 出现过就在出现的步数+1，没出现过就上一个步数+1
        for(int i=1;i<N;i++){
            int num = numArr[i];
            if(maps.get(num)<0){
                dp[i]=dp[i-1]+1;
                mp[num] = i;
                maps.replace(num,dp[i]);
            }else{
                dp[i] = Math.min(dp[i - 1] + 1, dp[mp[num]] + 1);
                dp[i] = maps.get(num)+1;
            }
        }
        System.out.println(dp[N-1]);
    }
}
