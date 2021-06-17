package concurrent.volatiledemo.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/6/17 6:12 下午
 * @Version: 1.0
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap();
        map.put(1,1);
    }
}
