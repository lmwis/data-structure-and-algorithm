package demo.pingcap;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-27 16:04
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Resources resources = new Resources();
        new Thread(()->{
            synchronized (resources.a){
                System.out.println(Thread.currentThread().getName()+"获取a的锁");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resources.b){
                    System.out.println(Thread.currentThread().getName()+"获取b的锁");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (resources.b){
                System.out.println(Thread.currentThread().getName()+"获取b的锁");
                synchronized (resources.a){
                    System.out.println(Thread.currentThread().getName()+"获取a的锁");
                }
            }

        }).start();
    }
}

class Resources{
    final Object a = new Object();
    final Object b = new Object();
}
