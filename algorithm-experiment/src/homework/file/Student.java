package homework.file;

public class Student {
    String num;
    public String name;
    String sex;
    String dormId;
    String institute;
    String classname;

    @Override
    public String toString() {
        return "Student{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", dormId='" + dormId + '\'' +
                ", institute='" + institute + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }

    Student(String num, String name, String sex, String dormId, String institute, String classname)
    {
        this.num=num;
        this.name=name;
        this.sex=sex;
        this.dormId=dormId;
        this.institute=institute;
        this.classname=classname;
    }
}
