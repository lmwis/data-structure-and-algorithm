package concurrent.volatiledemo.basicthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 线程池学习
 * @Author: lmwis
 * @Date 2020-12-14 19:40
 * @Version 1.0
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i=1;i<=10;i++){
            threadPool.execute(()->{
                System.out.println(Thread.currentThread()+"办理业务");
            });
        }

    }
}
