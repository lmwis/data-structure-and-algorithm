package wangyi;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-04-10 15:01
 * @Version 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        System.out.println(new Q1().billsChange(new int[]{10,10,10,10,10,5,5,5,5}));
    }

    public int billsChange (int[] bills) {
        // write code here
        int res = 0;
        int[] myBill = new int[]{2,0,0};// 5 10 20
        for(int i=0;i<bills.length;i++){

            if(bills[i]==5){ // 5
                myBill[0]++;
            }else if(bills[i]==10){ // 10
                if (myBill[0]>0){ // 有5块
                    myBill[0]--;
                    myBill[1]++;
                }else {
                    break;
                }
            }else { // 20 => 5|5|5 10|5
                if(myBill[0]>=3){ // 给三张5块
                    myBill[0]-=3;
                    myBill[2]++;
                }else if((myBill[0]>0)&&(myBill[1]>0)){ //给一张五块 一张10块 得到20
                    myBill[0]--;
                    myBill[1]--;
                    myBill[2]++;
                }else {
                    break;
                }
            }
            res++;
        }
        return res;
    }
}
