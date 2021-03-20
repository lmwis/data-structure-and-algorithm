package didi;

import java.util.*;

/**
 * @Description:
 * X星救援站
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * X星是宇宙中一个非常敬畏生命和热爱生命的星球。在X星上建有一个规模很大而且设备很先进的救援站。
 *
 * 为了方便救援工作的开展，X星规定：任意两点之间的一条边（即两个点之间的一条道路）出现问题，都不会将救援站和居民点之间的联系完全切断。也是说救援站到其他顶点都有两条或者两条以上的路线，这样在救援过程中，即使某一条路线出现问题，还可以通过其他路线到达目的地。
 *
 * 已知救援站和部分居民点之间，以及某些居民点之间有直接的边相连（所有的边均为无向边）。
 *
 * 现在请你编写一个程序，根据给出的救援站和居民点之间，以及某些居民点之间的连接信息，判断每一组输入数据是否满足X星的规定。如果满足规则请输出“Yes”，否则输出“No”。
 *
 *
 *
 * 输入描述
 * 多组输入，第1行输入一个正整数T表示输入数据的组数。
 *
 * 对于每一组输入数据：
 *
 * 第1行输入两个正整数N和M，其中N表示救援点和居民点的数量，对应N个顶点。其中编号为1的顶点表示救援点，编号为2到N表示(N-1)个居民点。M表示救援站和居民点之间，以及某些居民点之间边的数量。（N<=1000，M<=100000）
 *
 * 接下来M行每行包含两个正整数，分别为相邻的两个顶点（救援点或居民点）的编号，两个正整数之间用空格隔开。
 *
 * 输出描述
 * 针对每一组输入数据，如果输入数据满足X星的规定，任意一条边的断开都不会影响到救援站到居民点之间的连通性，输出“Yes”，否则输出“No”。
 *
 *
 * 样例输入
 * 2
 * 4 4
 * 1 2
 * 2 3
 * 3 4
 * 4 1
 * 4 4
 * 1 2
 * 2 3
 * 3 4
 * 1 3
 * 样例输出
 * Yes
 * No
 * @Author: lmwis
 * @Date 2021-03-20 19:34
 * @Version 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        String[] res = new String[t];
        for(int i=0;i<t;i++){
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] arr = new int[m][2];
            for(int j=0;j<m;j++){
                arr[j][0] = input.nextInt();
                arr[j][1] = input.nextInt();
            }
            res[i] = new Q2().function(arr,n);
        }
        Arrays.stream(res).forEach(System.out::println);
    }


    /**
     * 1如果只出现一次。那必然是No
     * 找奇数度旁边的奇数度
     * ？如果存在度为1的点就是No？
     * @param arr
     * @param n
     * @return
     */
    public String function(int[][] arr,int n){

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int key1 = arr[i][0];
            map.put(key1,map.getOrDefault(key1, 0)+1);
            int key2 = arr[i][1];
            map.put(key2,map.getOrDefault(key2, 0)+1);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            if(map.get(iterator.next())<=1){
                return "No";
            }
        }

//        System.out.println(Arrays.toString(arr[0]));
//        System.out.println(Arrays.toString(arr[1]));
//        System.out.println(Arrays.toString(arr[2]));
//        System.out.println(Arrays.toString(arr[3]));

        return "yes";
    }
}
