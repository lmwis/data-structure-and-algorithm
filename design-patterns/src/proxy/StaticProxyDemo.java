package proxy;

/**
 * @Description: 静态代理
 * @Author: lmwis
 * @Date 2021-03-20 11:21
 * @Version 1.0
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        Person person = new Student("小A");
        Person monitor = new StudentProxy(person);
        monitor.giveTask();
    }
}

interface Person{
    void giveTask();
}

class Student implements Person{
    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveTask() {
        System.out.println(name+"提交作业");
    }
}
class StudentProxy implements Person{
    Person person;

    public StudentProxy(Person person) {
        if(person.getClass()==Student.class){
            this.person = person;
        }
    }

    @Override
    public void giveTask() {
        System.out.print("代理：");
        person.giveTask();
    }
}
