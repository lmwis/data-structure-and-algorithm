package concurrent.volatiledemo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-17 20:35
 * @Version 1.0
 */
public class ReentrantLockDemo {

    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        new ReentrantLockDemo().doBusiness();

    }

    private void doBusiness() {
        lock.lock();;

        try {
            // do things

        }finally {
            lock.unlock();
        }

    }

}
