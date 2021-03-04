package concurrent.volatiledemo.basicthread;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-04 16:06
 * @Version 1.0
 */
public class WaitTest implements Runnable {
    static String lock = "lock";
    @Override
    public void run() {
        synchronized (WaitTest.class){
            System.out.println(Thread.currentThread().getName()+" enter");
            try {
                WaitTest.class.wait(3*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" after wait");
        }

    }

    public static void main(String[] args) {
        WaitTest t1 = new WaitTest();
        WaitTest t2 = new WaitTest();
        new Thread(t1).start();
        new Thread(t2).start();

    }
}
