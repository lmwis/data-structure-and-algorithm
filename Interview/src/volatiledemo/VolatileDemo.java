package volatiledemo;

import java.util.concurrent.TimeUnit;

/**
 * @Description: volatile 轻量级同步机制
 *  可见性demo : 某个线程对共享变量的操作结束后需要通知其他线程
 * @Author: lmwis
 * @Date 2020-10-26 12:30
 * @Version 1.0
 */
public class VolatileDemo {
    public static void main(String[] args) {
        Count count = new Count();

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"线程开启");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.setTo30();
            System.out.println(Thread.currentThread().getName()+"线程结束");
        }).start();

        new Thread(()->{
            while(count.num==0){

            }
            System.out.println(Thread.currentThread().getName()+"线程结束");
        }).start();
    }
}

class Count{
    volatile int num=0;
    void setTo30(){
        this.num = 30;
    }
}
