package exp5;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-11-12 20:15
 * @Version 1.0
 */
public class JDBCExp {
    private static final String host = "47.92.194.26";
    private static final String port = "6002";
    private static final String user = "root";
    private static final String password = "123456";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/student?characterEncoding=utf-8", user, password);
            // 先清空数据库
            Statement statement = connection.createStatement();
            statement.execute("delete from student_info");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCExp jdbcExp = new JDBCExp();
        Student stu1 = new Student("1","张A","男");
        Student stu2 = new Student("2","张B","男");
        Student stu3 = new Student("3","张C","女");
        Student stu4 = new Student("4","张D","女");
        try {
            // 插入
            System.out.println("插入数据");
            jdbcExp.insert(stu1);
            jdbcExp.insert(stu2);
            jdbcExp.insert(stu3);
            jdbcExp.insert(stu4);
            jdbcExp.showAllData();
            // 删除
            System.out.println("删除数据");
            jdbcExp.delete(2);
            jdbcExp.showAllData();
            // 修改
            System.out.println("修改数据");
            jdbcExp.update(new Student("3","刘C","男"));
            jdbcExp.showAllData();
            // 查询
            System.out.println("查询数据");
            Student student = jdbcExp.selectById(1);
            System.out.println(student);
            ArrayList ids = new ArrayList(){{
                add(3);
                add(4);
            }};
            List<Student> list = jdbcExp.selectByIds(ids);
            list.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showAllData() throws SQLException {
        System.out.println("当前数据库中数据：");
        System.out.println("==============");
        String sql = "select * from student_info";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(new Student(resultSet.getString("id")
                    ,resultSet.getString("name")
                    ,resultSet.getString("gender")));
        }
        System.out.println("==============");
    }
    /**
     * 增加
     * @return
     */
    public boolean insert(Student student) throws SQLException {
        //3.操作数据库，实现增删改查
        String sql = "insert into student_info values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,student.id);
        ps.setString(2,student.name);
        ps.setString(3,student.gender);
        return ps.execute();
    }

    /**
     * 删除
     * @return
     */
    public boolean delete(int id) throws SQLException {
        String sql = "delete from student_info where id='"+id+"'";
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }

    /**
     * 修改
     * @param student 学生
     * @return fail or success
     */
    public boolean update(Student student) throws SQLException {
        String sql = "update student_info set name='"+student.name+"' where id='"+student.id+"'";
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }

    /**
     * 根据id查询学生
     * @param id id
     * @return student
     */
    public Student selectById(int id) throws SQLException {
        String sql = "select * from student_info where id='"+id+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            return new Student(resultSet.getString("id")
                    ,resultSet.getString("name")
                    ,resultSet.getString("gender"));
        }
        return null;
    }

    /**
     * 根据多个id查询
     * @param ids ids
     * @return 学生集合
     */
    public List<Student> selectByIds(List<Integer> ids) throws SQLException {
        if(ids==null || ids.size()==0){
            return null;
        }
        List<Student> students = new ArrayList<>();
        Statement statement = connection.createStatement();
        ids.forEach(k->{
            try {
                String sql = "select * from student_info where id='"+k+"'";
                ResultSet resultSet = null;
                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
                    students.add(new Student(resultSet.getString("id")
                            ,resultSet.getString("name")
                            ,resultSet.getString("gender")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return students ;
    }
}
class Student{
    // 学号
    String id;
    // 姓名
    String name;
    // 性别
    String gender;

    public Student(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}