package meituan.qiu;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/11 4:30 下午
 * @Version: 1.0
 */
public class Q3 {

    /**
     * 18
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AtomicInteger count = new AtomicInteger();
        int n  = in.nextInt();
        int k  = in.nextInt();
        List<Song> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new Song(i,in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt()));
        }
        final int[] min = {-1};
        list.forEach(song -> {
            if ((song.a-song.b)<0){
                min[0] = song.id;
            }
        });
        if (min[0]>-1){
            list.remove(min[0]); // 只删除负的
            count.addAndGet(-k);
        }


        Map<Integer,Integer> readMap = new HashMap<>(); // 记录读过的序列
        list.forEach(song -> {
            Integer integer = readMap.getOrDefault(song.c,0);
            if (integer+1 == song.d){ // 同一序列接力
                count.addAndGet(song.a);
                // 序列更新
                readMap.put(song.c, song.d);
            }else {
                count.addAndGet(song.a-song.b);
            }
        });
        System.out.println(count.get());
        // 去掉a-b最小的
    }
    static class Song{
        int id;
        int a;
        int b;
        int c;
        int d;
        public Song(int id,int a, int b, int c, int d) {
            this.id = id;
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
}
