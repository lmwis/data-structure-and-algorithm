package exp4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-11-06 19:23
 * @Version 1.0
 */
public class LotteryDemo {

    public static void main(String[] args) {
        LotteryDemo lotteryDemo = new LotteryDemo();
        System.out.println(lotteryDemo.getLotteryArray(LotteryType.TwoTwoOufOf5));
        System.out.println(lotteryDemo.getLotteryArray(LotteryType.ThreeThreeOutOf7));
        System.out.println(lotteryDemo.getLotteryArray(LotteryType.TwoColorBall));

    }

    String getLotteryArray(LotteryType type) {
        List<String> res = new ArrayList<>();
        switch (type) {
            case TwoColorBall:
                for (int i = 0; i < 6; i++) {
                    res.add(String.valueOf((int) (Math.random() * 32) + 1));
                }
                res.add(String.valueOf((int) (Math.random() * 15) + 1));
                break;
            case TwoTwoOufOf5:
                for (int i = 0; i < 5; i++) {
                    res.add(String.valueOf((int) (Math.random() * 21) + 1));
                }
                break;
            case ThreeThreeOutOf7:
                for (int i = 0; i < 7; i++) {
                    res.add(String.valueOf((int) (Math.random() * 32) + 1));
                }
        }
        return String.join(",", res);
    }
}

enum LotteryType {
    TwoTwoOufOf5,
    ThreeThreeOutOf7,
    TwoColorBall
}
