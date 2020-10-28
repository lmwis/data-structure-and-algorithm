package volatiledemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description:
 *  集合类不安全问题
 *  如何解决：
 *  1.使用vector类，该类的方法用synchronized修饰，并发性下降
 *  2.使用Collections.synchronizedList(new ArrayList<>())构造加锁的线程安全类，原理是synchronized代码块修饰
 *  3.CopyOnWriteArrayList类 写时复制与读写分离思想
 * @Author: lmwis
 * @Date 2020-10-28 14:49
 * @Version 1.0
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add((int) (Math.random() * 10) + 1);
                System.out.println(list);
            }).start();
        }
    }
}
