package concurrent.volatiledemo.basicthread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * Executor & Daemon
 * Executor:管理多个异步任务的执行，而无需程序员显式地管理线程的生命
 *  周期。这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。
 * Daemon:守护线程是程序运行时在后台提供服务的线程，不属于程序中不可或缺的部分。
 * @Author: lmwis
 * @Date 2020-11-15 20:19
 * @Version 1.0
 */
public class BasicThreadMechanism {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<?> submit = executor.submit(() -> {
            System.out.println("000");
        });

        Lock lock = new ReentrantLock(true);
    }
}
