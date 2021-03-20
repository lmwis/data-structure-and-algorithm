package meituan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description: 时间限制： 3000MS
 * 内存限制： 786432KB
 * 题目描述：
 * 学校正在举行喝奶茶比赛。这次比赛准备了 n 杯奶茶（为了比赛公平，奶茶里没有珍珠，椰果等各种小料，也就是纯奶茶），编号为 1 到 n。第 i 杯奶茶有 ai 毫升，这 n 杯奶茶准备的吸管都是一样的，每秒最多能吸上来 C 毫升奶茶，选手只能通过吸管吸奶茶，不能捅破包装把奶茶倒进嘴里，这样对其他选手不公平。
 * <p>
 * 选手按队伍参赛，小团所在的队伍有 m 个人，比赛要求队内的每个人选取编号在一个连续区间的奶茶喝，当然参赛选手也可以不喝任何奶茶。但是选定一杯奶茶喝就一定要喝完，不然的话这杯奶茶就被浪费了。
 * <p>
 * 如果小团所在队打破了校记录，那么她们队的每个人都将获得一年的奶茶畅饮卷，所以她想知道所有奶茶都被喝完的最短用时。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行三个整数 n, m, C，意义如题目描述。
 * <p>
 * 第二行 n 个整数，第 i 个整数为 ai。
 * <p>
 * 1 ≤ n, m ≤ 105, 1 ≤ C ≤ 50, 1 ≤ ai ≤ 104。
 * <p>
 * 输出描述
 * 输出一行一个整数，表示所有奶茶都被喝完的最短用时，为了保证精度，请输出答案上取整后的结果。
 * <p>
 * <p>
 * 样例输入
 * 5 3 4
 * 5 8 3 10 7
 * @Author: lmwis
 * @Date 2021-03-20 17:16
 * @Version 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int c = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(function(arr, m, c));

    }

    public static int function(int[] arr, int m, int c) {
        int sum = 0;
        boolean ex = true;
        Arrays.sort(arr);
        for (; ; ) {
            sum++;
            for (int i = m - 1; i < arr.length; i++) {

//                flag[i] = true;
                arr[i] = arr[i] - c;
                if (arr[i] <= 0) { // 喝完的时候
                    if (arr[m - 2] <= 0) {
                        continue;
                    }
                    arr[i] = arr[m - 2];
                    arr[m - 2] = 0;
                    int[] newArr = new int[arr.length - 3];
                    for (int j = 0; j < arr.length - m; j++) {
                        newArr[j] = arr[j];
                    }
                    Arrays.sort(newArr);
                    for (int j = 0; j < arr.length - m; j++) {
                        arr[j] = newArr[j];
                    }
//                        empty[i] = true;
//                        flag[i] = false;
//                }else{
//                    int index = i;
//                    while(--index>=0){
//                        if(!flag[index]){ // 没人喝
//                            flag[index] = true;
//                            arr[index] = arr[index]-c;
//                            if(arr[index]<=0){
//                                empty[index] = true;
////                                flag[index] = false;
//                            }
//                            break;
//                        }
//                    }
//                    i = index;
                }
            }
            ex = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    ex = false;
                }
            }
            if (ex) {
                break;
            }
        }
        return sum;
    }
}
