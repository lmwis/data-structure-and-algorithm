package concurrent.volatiledemo;

/**
 * @Description: DCL + volatile 单例模式优化
 * 由于指令重排机制的存在，使得DCL单例模式在多线程环境下不安全
 * 因此使用volatile禁用指令重排保证多线程下单例安全
 * @Author: lmwis
 * @Date 2020-10-27 20:08
 * @Version 1.0
 */
public class DCLVolatileSingletonDemo {

    private static volatile DCLVolatileSingletonDemo singletonDemo = null;

    private  DCLVolatileSingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"构造函数");
    }

    /**
     * 原始版单例实现：DCL (Double Check Lock) 双端检索机制
     * @return
     */
    public static DCLVolatileSingletonDemo getInstance(){
        if(singletonDemo==null){
            synchronized (DCLVolatileSingletonDemo.class){
                if(singletonDemo==null){
                    singletonDemo = new DCLVolatileSingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(DCLVolatileSingletonDemo::getInstance).start();
        }
    }
}
