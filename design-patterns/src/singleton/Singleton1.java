package singleton;

/**
 * @Description: [懒汉式]单例模式实现
 * @Author: lmwis
 * @Date 2021-01-28 20:43
 * @Version 1.0
 */
public class Singleton1 {
    private Singleton1 singleton1;

    /**
     * 构造器私有防止被外部实例化
     */
    private Singleton1(){

    }

    /**
     * 线程不安全
     * @return
     */
    public Singleton1 getInstance1(){
        if(singleton1==null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

    /**
     * 并发度低的线程安全
     * <p>
     *     不推荐使用
     * </p>
     * @return
     */
    public synchronized Singleton1 getInstance2(){
        if(singleton1==null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

    /**
     * 并发度高的线程安全
     * 双端校验 Double Check Lock
     * <p>
     *     推荐使用
     * </p>
     * <p>
     *     存在DCL失效问题：由JVM指令重排机制导致
     *     解决办法：用 volatile 修饰 singleton1 禁止指令重排
     * </p>
     * @return
     */
    public Singleton1 getInstance3(){
        if(singleton1==null){
            synchronized (Singleton1.class){
                if(singleton1==null){
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
