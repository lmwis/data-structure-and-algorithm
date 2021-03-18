package concurrent.volatiledemo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: 循环屏障
 * 等所有线程都到达某一状态后，再同时执行
 * @Author: lmwis
 * @Date 2021-03-18 10:56
 * @Version 1.0
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier  = new CyclicBarrier(5);
        for(int i=0;i<5;i++){
            new Thread(new BusinessThread(cyclicBarrier)).start();
        }

    }
}
class BusinessThread implements Runnable{

    CyclicBarrier cyclicBarrier ;

    public BusinessThread(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("执行其他任务");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //抵达屏障等待其他线程到达
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("线程到达并发执行后续任务");
    }
}
