package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * 2
 * 1
 * 1 1
 * 10 5 10
 * 3
 * 10 5
 * 10 5 6
 * 10 5 7
 * 10 5 8
 * @Author: lmwis
 * @Data: 2021/8/28 3:33 下午
 * @Version: 1.0
 */
public class G1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int[] res = new int[T];
        for(int i = 0; i < T; i++){
            int mCount = in.nextInt();
            int ak = in.nextInt();
            int pm = in.nextInt();
            int[][] mValue = new int[mCount][3];
            for(int j=0;j<mCount;j++){
                mValue[j][0] = in.nextInt(); // 攻击力
                mValue[j][1] = in.nextInt(); // 防御力
                mValue[j][2] = in.nextInt(); // 生命值
            }
            res[i] = new G1().vsGame(ak,pm,mCount,mValue);
        }
        Arrays.stream(res).forEach(System.out::println);
    }
    public int vsGame(int ak,int pm,int mCount, int[][] mValue){
        // 攻击力小于防御力必败
        int res = 0;
        int outOf = 0;
//        int lastOutOf = 0;
        for (int i=0;i<mCount;i++){
            int hit = ak - mValue[i][1];
            if(hit<=0){ // 攻击力小于等于防御力必败
                return -1;
            }
            int times = (mValue[i][2] / hit) +1; // 需要打的次数
            outOf += hit - (mValue[i][2] % hit); // 溢出
            int bHit = Math.max((mValue[i][0] - pm), 0);

            res += bHit*(times-1);
//            res += bHit*(times-1)-lastOutOf;
//            lastOutOf = mValue[i][2] % hit; // 溢出
        }

        return Math.max((res-outOf)+mCount,1);
//        return res;
    }
}
