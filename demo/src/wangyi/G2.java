package wangyi;

import java.util.*;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/8/28 4:12 下午
 * @Version: 1.0
 */
public class G2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int[] res = new int[T];
        for(int i = 0; i < T; i++){
            int count = in.nextInt();
            Map<Integer, List<Integer>> works = new HashMap<>();
            Map<Integer, Integer> worksMap = new HashMap<>();
            for(int j=0;j<count;j++){
                int workDay = in.nextInt();
                int preCount = in.nextInt();
                List<Integer> preWorks = new ArrayList<>();
                for(int k = 0;k<preCount;k++){
                    preWorks.add(in.nextInt());
                }
                worksMap.put(j+1,workDay);
                works.put(workDay,preWorks);
            }
            res[i] = new G2().preTime(count,works,worksMap);
        }
        Arrays.stream(res).forEach(System.out::println);
    }
    public int preTime(int count, Map<Integer, List<Integer>> works,Map<Integer, Integer> worksMap){
        int res = 0;
//        while(true){
//
//        }
        return res;
    }
}
