package singleton;

/**
 * @Description: [静态内部类]模式
 *
 * 既做到了不使用不加载，同时也保证了线程安全
 *
 * 缺点：无法外部传参构造
 *
 * @Author: lmwis
 * @Date 2021-01-28 21:16
 * @Version 1.0
 */
public class Singleton3 {

    private Singleton3(){

    }
    private static class SingletonHoler{
        private static Singleton3 instance = new Singleton3();
    }
    public static Singleton3 getInstance(){
        return SingletonHoler.instance;
    }
}
