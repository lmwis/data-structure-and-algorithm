package array;
/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-26 21:21
 * @Version 1.0
 */
public class CountSmaller {
    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();

        for (int i : countSmaller.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})) {
            System.out.println(i);
        }
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    res[i] +=1;
                }else if(nums[i]<nums[j]){
                    res[j] +=1;
                }
            }
        }
        return res;
    }
}
