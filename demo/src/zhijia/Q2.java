package zhijia;

/**
 * @Description:
 *
 *
// 正到负发生碰撞
// 1 2 -3 4 -5 -6 7 // 2-3 4-5
// 1 -2 3 -4 5 -6 7 // 1-2 3-4 5-6
//-1 2 -3 4 -5 6 7 // 2-3 4-5
// -1 -2 3 -4 5 6 7 // 3-4
// -1 -2 -3 4 5 6 7


// 1 2 -3 4 -5 -6 -7 // 2-3 4-5
// 1 -2 3 -4 5 -6 -7 // 1-2 3-4 5-6
//-1 2 -3 4 -5 6 -7 // 2-3 4-5 6-7
// -1 -2 3 -4 5 -6 7 // 3-4 5-6
// -1 -2 -3 4 -5 6 7 // 4-5
// -1 -2 -3 -4 5 6 7

 * @Author: lmwis
 * @Data: 2021/11/18 2:35 下午
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        System.out.println(new Q2().eCollision(new int[]{1, 2, -3, 4, -5, -6, -7}));
    }
    public int eCollision (int[] balls) {
        // write code here
        int[] after = new int[balls.length];
        int times = 0;
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=0;i<balls.length-1;i++){
                if(balls[i]>0 && balls[i+1]<0){
                    times++;
                    after[i] = -balls[i];
                    after[i+1] = -balls[i+1];
                    flag = true;
                    i++;
                    if(i==balls.length-2){
                        after[i+1] = balls[i+1];
                    }
                }else{
                    after[i] = balls[i];
                    if(i==balls.length-2){
                        after[i+1] = balls[i+1];
                    }
                }
            }
            int[] temp = balls;
            balls = after;
            after = temp;
        }

        return times;
    }
}
