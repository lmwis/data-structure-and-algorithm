package easy;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/6/14 2:36 下午
 * @Version: 1.0
 */
public class GuessGame {

    public int guess(int obj) {
        return 0;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int cur = left+(right-left) /2 ; // 同样防int溢出
            int temp = guess(cur);
            if(temp==0){
                return cur;
            }else if(temp==-1){
                right = cur-1;
            }else{
                // 1
                left = cur+1;
            }
        }
        return 0;
    }
}
