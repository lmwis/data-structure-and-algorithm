package concurrent.volatiledemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: volatile 轻量级同步机制
 *  可见性demo : 某个线程对共享变量的操作结束后需要通知其他线程
 *  不保证原子性demo : 在某个线程对变量操作完之前被其他线程抢占导致重复写入写丢失
 * @Author: lmwis
 * @Date 2020-10-26 12:30
 * @Version 1.0
 */
public class VolatileDemo {
    public static void main(String[] args) {
//        demoForSeeAble();
        demoForNoAtomic();
    }

    /**
     * 不保证原子性如何解决：
     * 1.使用重量级synchronized(不支持，杀鸡焉用牛刀)
     * 2.使用java.util.concurrent.atomic包下的原子包装类 AtomicInteger ,底层原理为CAS
     */
    private static void demoForNoAtomic() {
        Count count = new Count();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    count.addNum();
                    count.addAtomicNum();
                }
            }).start();
        }

        // 一个是主线程一个是GC线程
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(count.num);
        System.out.println(count.atomicInteger);
    }

    /**
     * 可见性demo
     * 一个线程对共享变量的改变会通知到另外一个线程
     */
    private static void demoForSeeAble() {
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
    AtomicInteger atomicInteger = new AtomicInteger();
    void setTo30(){
        this.num = 30;
    }
    void addNum(){
        num++;
    }
    void addAtomicNum(){
        // i++;
        atomicInteger.getAndIncrement();
    }
}
