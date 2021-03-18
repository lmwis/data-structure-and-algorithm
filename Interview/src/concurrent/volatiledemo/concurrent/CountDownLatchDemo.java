package concurrent.volatiledemo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-18 10:51
 * @Version 1.0
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(()->{
            System.out.println("线程1执行中");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1执行完毕");
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            System.out.println("线程2执行中");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2执行完毕");
            countDownLatch.countDown();
        }).start();

        try {
            // 阻塞等待计数器完成
            countDownLatch.await();
            System.out.println("计数器完成执行主任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
