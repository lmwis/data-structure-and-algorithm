package homework.file;

import java.io.*;
import java.util.ArrayList;

/**
 * 对学生宿舍信息文件的操作
 * 包括增删查改
 *
 * @author Cassie
 */
public class StudentDeal {
    private final String FILE_PATH = "D:\\Project\\data-structure-and-algorithm\\algorithm-experiment\\src\\homework\\file\\DormitoryInfo.txt";
    //    通过学号查询学生信息
    Student findStuByNum(String num) {
        Student result = null;
        try {
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine(); // 读取第一行数据
            while (temp != null) {
                String[] infos = temp.split("@");
                if (infos[0].equals(num)) {
                    result = new Student(infos[0], infos[1], infos[2], infos[3], infos[4], infos[5]);
                    break;
                }
                temp = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    //    通过姓名查询学生信息
    public Student[] findStusByName(String name) {
        ArrayList<Student> result = new ArrayList<Student>();
        try {
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine(); // 读取第一行数据
            while (temp != null) {
                String[] infos = temp.split("@");
                if (infos[0].equals(name)) {
                    result.add(new Student(infos[0],infos[1],infos[2], infos[3], infos[4], infos[5]));
                    break;
                }
                temp = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return (Student[]) result.toArray(new Student[result.size()]);
    }

    //    通过学院查询学生信息
    public Student[] findStusByInstitude(String institude){
        ArrayList<Student> result = new ArrayList<Student>();
        try {
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();
            //读取第一行数据
            while (temp != null) {//判断是否到文件的尾部
                String[] infos = temp.split("@");
                //将一行数据切割成一个字符串数组
                if (infos[1].equals(institude)) {
                    result.add(new Student(infos[0], infos[1], infos[2], infos[3], infos[4], infos[5]));
                }
                temp = br.readLine();
                //再次读取一行数据
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return (Student[]) result.toArray(new Student[0]);
    }

    //    判断学号是否存在
    private boolean checkNumIsExist(String num) {
        boolean result = false;
        try {
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();
            //读取第一行数据
            while (temp != null)//判断是否到文件的尾部
            {
                String[] infos = temp.split(",");
                //将一行数据切割成一个字符串数组
                if (infos[0].equals(num)) {
                    result = true;
                    break;
                }
                temp = br.readLine();
                //再次读取一行数据
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    //    增加学生信息
    void addStudent(Student stu) {
        if (!checkNumIsExist(stu.num)) {
            try {
                FileWriter fw = new FileWriter(FILE_PATH, true);
                //以追加方式写文件
                BufferedWriter bw = new BufferedWriter(fw);
                StringBuffer str = new StringBuffer();
                str.append(stu.num + "@");
                str.append(stu.name + "@");
                str.append(stu.sex + "@");
                str.append(stu.dormId + "@");
                str.append(stu.institute + "@");
                str.append(stu.classname);
                bw.newLine();
                //新增一行
                bw.write(str.toString());
                bw.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private ArrayList<Student> findAllStus() {
        ArrayList<Student> result = new ArrayList<Student>();
        try {
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();
            //读取第一行数据
            while (temp != null)//判断是否到文件的尾部
            {
                String[] infos = temp.split("@");
                //将一行数据切割成一个字符串数组
                result.add(new Student(infos[0], infos[1], infos[2], infos[3], infos[4], infos[5]));
                temp = br.readLine();
                //再次读取一行数据
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    //    删除学生宿舍信息
    void delStuByNum(String num) {
        if (checkNumIsExist(num))//判断学号是否已经存在
        {
            ArrayList<Student> stus = findAllStus();
            //获取所有的学生信息，保存到集合对象中
            for (int i = 0; i < stus.size(); i++) {
                Student temp = (Student) stus.get(i);
                if (temp.num.equals(num)) {
                    stus.remove(temp);
                    break;
                }
            }
            try {
                FileWriter fw = new FileWriter(FILE_PATH);
                //以追加方式写文件
                BufferedWriter bw = new BufferedWriter(fw);
                for (Student student : stus) {
                    Student temp = (Student) student;
                    StringBuffer str = new StringBuffer();
                    str.append(temp.num + "@");
                    str.append(temp.name + "@");
                    str.append(temp.sex);

                    //新增一行
                    bw.write(str.toString());
                    bw.newLine();
                }

                bw.close();
                fw.close();
            } catch (IOException ignored) {
            }
        }
    }

    public void delStus(String[] nums) {
        if (nums.length > 0) {
            for (String num : nums) {
                delStuByNum(num);
            }
        }
    }

    //    修改学生宿舍信息
    void updateStu(Student stu) {
        delStuByNum(stu.num);
        addStudent(stu);
    }

    public void updateStus(Student[] stus) {
        if (stus.length > 0) {
            for (Student student : stus) {
                updateStu(student);
            }
        }
    }

    void showInfos(){
        findAllStus().forEach(System.out::println);
    }
}
