package wxg;

/**
 * @Description:
 * 假设c库中有函数rand()能够生成均匀随机的0 - 65535的随机数，现有30万员工参与抽奖，请使用rand()函数编写一个完整的可执行程序，从这30万员工中随机抽取10万名中奖员工
 * @Author: lmwis
 * @Data: 2021/9/14 6:12 下午
 * @Version: 1.0
 */
public class Q3 {
    /**
     * 范围：1-300000 调用100000次
     * @return
     */
    public int rand30(){


        int[] arr = new int[300000];
        for (int i = 0; i < 300000; i++) {
            int a1 = rand6w();
            int a2 = rand6w();
            int a3 = rand6w();
            int a4 = rand6w();
            int a5 = rand6w();
            int x = a1*a2*a3*a4*a5;
            arr[i] = x;
        }
//        Set
        for (int i : arr) {

        }
        return 0;
    }

    /**
     * 1-60000
     * @return
     */
    public int rand6w(){
        while (true){
           int temp = rand();
           if(temp<60000){
               return temp;
           }
        }
    }

    public int rand(){
        return 0;
    }
}
