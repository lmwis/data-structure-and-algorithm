package array.easy;

import java.util.*;

/**
 * @Description: 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 示例 1：
 *
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * @Author: lmwis
 * @Date 2020-12-10 11:03
 * @Version 1.0
 */
public class LemonadeChange {
    public static void main(String[] args) {
        //[5,5,5,5,10,5,10,10,10,20]
        System.out.println(new LemonadeChange().lemonadeChange(new int[]{5,5,5,5,10,5,10,10,10,20}));
    }

    /**
     * 我是傻逼
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        if(bills==null||bills.length==0){
            return true;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                Integer orDefault = map.getOrDefault(5, 0);
                orDefault++;
                map.put(5,orDefault);
                continue;
            }
            // 判断前面有5
            if(bills[i]==10){
                if(map.containsKey(5)){
                    Integer orDefault1 = map.getOrDefault(5, 0);
                    orDefault1--;
                    if(orDefault1<=0){
                        map.remove(5);
                    }else {
                        map.put(5,orDefault1);
                    }
                    Integer orDefault2 = map.getOrDefault(10, 0);
                    orDefault2++;
                    map.put(10,orDefault2);
                    continue;
                }
                return false;
            }
            // 前面有15 ，三种方式，10*1+5*1 or 5*3
            if(bills[i]==20){
                if(map.containsKey(10)&&map.containsKey(5)&&map.get(5)>=1){
                    Integer orDefault1 = map.getOrDefault(5, 0);
                    orDefault1--;
                    if(orDefault1<=0){
                        map.remove(5);
                    }else {
                        map.put(5,orDefault1);
                    }
                    Integer orDefault3 = map.getOrDefault(10, 0);
                    orDefault3--;
                    if(orDefault3<=0){
                        map.remove(10);
                    }else {
                        map.put(10,orDefault3);
                    }
                    Integer orDefault2 = map.getOrDefault(20, 0);
                    orDefault2++;
                    map.put(20,orDefault2);
                    continue;
                } else if(map.containsKey(5)&&map.get(5)>=3){
                    Integer orDefault1 = map.getOrDefault(5, 0);
                    orDefault1-=3;
                    if(orDefault1<=0){
                        map.remove(5);
                    }else {
                        map.put(5,orDefault1);
                    }
                    Integer orDefault2 = map.getOrDefault(20, 0);
                    orDefault2++;
                    map.put(20,orDefault2);
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public boolean lemonadeChangeBest(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
