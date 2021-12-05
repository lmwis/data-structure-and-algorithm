package easy;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/12/5 8:00 下午
 * @Version: 1.0
 */
public class IsStraight {
    public static void main(String[] args) {
        new IsStraight().isStraight(new int[]{

                9,0,6,0,10});
    }
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        int pre = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }else{
                if(pre!=-1){
                    int temp = nums[i]-pre-1;
                    if(temp!=0){ // 如果不连续
                        if(pre==nums[i]){
                           return false;
                        }
                        if(zero==0){ // 如果没有鬼牌
                            return false;
                        }else{ // 有鬼牌
                            if(temp>zero){ // 鬼牌数量不够
                                return false;
                            }else {
                                zero = zero-temp;
                                pre = nums[i];
                            }
                        }
                    }else{
                        pre = nums[i];
                    }
                }else{
                    pre = nums[i];
                }

            }
        }
        return true;
    }
}
