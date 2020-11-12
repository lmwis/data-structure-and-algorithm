package exp5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-11-12 20:15
 * @Version 1.0
 */
public class JDBCExp {
    private static final String host = "47.92.194.26";
    private static final String password = "123456";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/imooc", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 增加
    public boolean insert(){
        return true;
    }

    // 删除
    public boolean delete() {
        return true;
    }
}
