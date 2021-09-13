package tongcheng;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/11 8:42 下午
 * @Version: 1.0
 */
public class Q2 {
    public int[] subArraySum (int[] Array, int arrayLen, int subArrayLen) {
        // write code here
        int[] res = new int[2];
        int right = subArrayLen-1;
        int idx = 0;
        int max = count(Array,idx,right);
        int left = 0;
        while(right<arrayLen){
            int temp = count(Array,left,right);
            if (temp>max){
                idx = left;
                max = temp;
            }
            left++;
            right++;
        }
        res[0] = idx;
        res[1] = max;
        return res;
    }
    public int count(int[] array,int left,int right){
        int count =0;
        for (int i = left; i <= right; i++) {
            count+=array[i];
        }
        return count;
    }
}
