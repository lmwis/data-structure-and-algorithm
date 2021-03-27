package ali;

/**
 * @Description: leetcode 1318
 * @Author: lmwis
 * @Date 2021-03-20 11:28
 * @Version 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Integer a = 300;
        Integer b = 300;
        System.out.println(a==b);

        Student stu = new Student();
        stu.age=10;
        System.out.println(stu.age);  // 10
        new Q1().function(stu);
        System.out.println(stu.age); // 10


        System.out.println("======================");
        Integer s = new Integer(10);
        System.out.println(s);
        new Q1().function(s);
        System.out.println(s);
    }

    public void function(Student student){

        student.age=20;

    }
    public void function(Integer student){
        student=20;
    }
}
class Student{
    public int age;
}