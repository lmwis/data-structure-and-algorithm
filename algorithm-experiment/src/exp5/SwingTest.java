package exp5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.StringTokenizer;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-11-12 20:05
 * @Version 1.0
 */
public class SwingTest {
    public static void main(String[] args) {
        StudentSystem frame = new StudentSystem("添加学生记录");
    }

}

class StudentSystem extends JFrame {
    JPanel panel;

    public StudentSystem(String title) {
        super(title);
        panel = new JPanel();
        JLabel stunoLabel = new JLabel("学号");
        stunoLabel.setBounds(75, 20, 80, 30);
        stunoLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        panel.add(stunoLabel);

        // 学号输入框
        JTextField stunoText = new JTextField(20);
        stunoText.setBounds(145, 20, 170, 30);
        stunoText.setFont(new Font("微软雅黑", Font.BOLD, 16));
        panel.add(stunoText);

        //姓名
        JLabel nameLabel = new JLabel("姓名");
        nameLabel.setBounds(75, 80, 80, 30);
        nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        panel.add(nameLabel);

        //姓名输入框
        JTextField nameText = new JTextField(25);
        nameText.setBounds(145, 80, 170, 30);
        nameText.setFont(new Font("微软雅黑", Font.BOLD, 16));
        panel.add(nameText);

        //性别
        JLabel sexLabel = new JLabel("性别");
        sexLabel.setBounds(75, 140, 80, 30);
        sexLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        panel.add(sexLabel);

        //性别选择
        JComboBox<String> sexBox = new JComboBox<>();
        sexBox.addItem("男");
        sexBox.addItem("女");
        sexBox.setBounds(145, 140, 80, 30);
        panel.add(sexBox);

        JButton addButton = new JButton("添加");
        addButton.setBounds(100, 200, 80, 30);
        addButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        JDBCExp jdbcExp = new JDBCExp();
        addButton.addActionListener(e -> {
            String id = stunoText.getText();
            String name = nameText.getText();
            String gender = sexBox.getItemAt(sexBox.getSelectedIndex());
            if(id.isEmpty()||name.isEmpty()||gender.isEmpty()){
                JOptionPane.showMessageDialog(this.getContentPane(),
                        "请输入用户信息", "系统提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Student student = new Student(id, name, gender);
            try {
                jdbcExp.insert(student);
                JOptionPane.showMessageDialog(this.getContentPane(),
                        "添加成功", "系统提示", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this.getContentPane(),
                        "添加失败，用户已存在", "系统提示", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(addButton);

        JButton clearButton = new JButton("清空");
        clearButton.setBounds(200, 200, 80, 30);
        clearButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        panel.add(clearButton);
        panel.setLayout(null);
        clearButton.addActionListener(e -> {
            stunoText.setText("");
            nameText.setText("");
            sexBox.setSelectedIndex(0);
        });

        this.add(panel);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); //设置界面可见
    }
}