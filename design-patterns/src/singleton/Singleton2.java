package singleton;

/**
 * @Description: [饿汉式]单例模式实现
 * @Author: lmwis
 * @Date 2021-01-28 21:05
 * @Version 1.0
 */
public class Singleton2 {

    private Singleton2 singleton2 = new Singleton2();

    /**
     * 构造器私有防止被外部实例化
     */
    private Singleton2(){

    }

    /**
     * 以空间换时间，故不存在线程安全问题。
     * @return
     */
    public Singleton2 getInstance() {
        return singleton2;
    }
}
