package proxy;

/**
 * @Description: 基于 CGLib(Code Generator Library)的动态代理
 * 需要导入库
 * @Author: lmwis
 * @Date 2021-03-21 13:35
 * @Version 1.0
 */
public class CGLibDynamicProxyDemo {

    public static class Student{
        String name;

        public Student(String name) {
            this.name = name;
        }

        public void giveTask(){
            System.out.println(name+"交作业");
        }
    }

    // 需要第三方CGLib库
//    public static class MyMethodInterceptor implements MethodInterceptor{
//
//    }

}
