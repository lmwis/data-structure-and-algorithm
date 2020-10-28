package array;

import java.util.Arrays;

/**
 * @Description: 独一无二出现的次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * @Author: lmwis
 * @Date 2020-10-28 12:45
 * @Version 1.0
 */
public class UniqueAppearanceCount {
    public static void main(String[] args) {
        UniqueAppearanceCount uniqueAppearanceCount = new UniqueAppearanceCount();
        System.out.println(uniqueAppearanceCount.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        int[] res = new int[2001];
        for(int i=0;i<arr.length;i++){
            int index = arr[i];
            if(index<0){
                index = Math.abs(index)+1000;
            }
            res[index] +=1;
        }
        Arrays.sort(res);
        for(int i=0;i<res.length-1;i++){
            //     if(re[res[i]]==1&&res[i]>0) {
            //         return false;
            //     }
            //     re[res[i]]=1;
            if(res[i]==res[i+1]&&res[i]>0){
                return false;
            }
        }
        return true;
    }
}
