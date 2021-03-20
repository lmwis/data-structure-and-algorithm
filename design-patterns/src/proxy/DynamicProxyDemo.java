package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 动态代理的代理类是在程序运行时创建
 * 动态代理的优势在于可以很方便的对代理类的函数进行统一的处理
 * 可以一次将类中所有的方法都进行代理而不需要手动扩充
 * @Author: lmwis
 * @Date 2021-03-20 11:37
 * @Version 1.0
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        DynamicProxyDemo dynamicProxyDemo = new DynamicProxyDemo();
        dynamicProxyDemo.method();

    }
    void method(){
        Person person = new Student("小A");
        StudentInvocationHandler studentInvocationHandler = new StudentInvocationHandler<Person>(person);

        Person studentProxy = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},studentInvocationHandler);
//        studentProxy.giveMask();
//        studentProxy.cleanClass();
        System.out.println(studentProxy.getClass());

//        Person badStudent = new BadStudent("大A");
//        StudentInvocationHandler badStudentInvocationHandler = new StudentInvocationHandler<Person>(badStudent);
//        Person badPerson = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},badStudentInvocationHandler);
//        badPerson.giveMask();
//        badPerson.cleanClass();
//        System.out.println(badPerson.getClass());
//        Person badPerson2 = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},badStudentInvocationHandler);
//        badPerson2.giveMask();
//        badPerson2.cleanClass();
//        System.out.println(badPerson2.getClass());
        for(int i=0;i<10;i++){
            int finalI = i;
            new Thread(()->{
                System.out.println("====");
                System.out.println("第"+ finalI +"次创建");
                Person proxy = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},studentInvocationHandler);
                System.out.println(proxy.getClass());
                System.out.println("====");
            }).start();
        }
    }

    interface Person{
        void giveMask();
        void cleanClass();
    }

    class Student implements Person{
        String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public void giveMask() {
            System.out.println(name+"交作业");
        }

        @Override
        public void cleanClass() {
            System.out.println(name+"打扫教室");
        }
    }

    class BadStudent implements Person{
        String name;

        public BadStudent(String name) {
            this.name = name;
        }

        @Override
        public void giveMask() {
            System.out.println("坏学生"+name+"不交作业");
        }

        @Override
        public void cleanClass() {
            System.out.println("坏学生"+name+"不打扫教室");
        }
    }

    class StudentInvocationHandler<T> implements InvocationHandler{
        T target;

        public StudentInvocationHandler(T target) {
            this.target = target;
        }

        /**
         * 代理类所有执行的方法都会被替换为这个invoke方法
         * @param proxy
         * @param method
         * @param args
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代理执行"+method.getName()+"方法");
            Object result = method.invoke(target,args); // 执行原方法
//            System.out.println("我不执行被代理类的方法");
//            return null;
            return result;
        }
    }

}


