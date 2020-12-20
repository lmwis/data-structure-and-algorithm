package homework;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-12-20 14:53
 * @Version 1.0
 */
public class Combobox extends JFrame {
    JPanel comboBoxPanel = new JPanel();

    private static String[] academys = {"电子信息与人工智能学院", "轻工科学与工程学院"};
    private static String[][] majors = {
            {"计算机科学与技术", "网络工程", "物联网", "电子信息工程", "电子科学与技术", "光电信息与科学"},
            {"轻化工程", "印刷与包装", "非织造"}
    };

    private void initComboBox() {
        comboBoxPanel.setSize(400, 400);
        comboBoxPanel.setLocation(50, 80);
        comboBoxPanel.setLayout(null);
        JLabel academyLabel = new JLabel("学院");
        academyLabel.setBounds(20, 50, 50, 40);
        academyLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        comboBoxPanel.add(academyLabel);

        JLabel majorLabel = new JLabel("专业");
        majorLabel.setBounds(20, 150, 50, 40);
        majorLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        comboBoxPanel.add(majorLabel);

        JComboBox academyBox = new JComboBox(academys); // 学院下拉框
        academyBox.setBounds(100, 50, 200, 40);
        academyBox.setFont(new Font("微软雅黑", Font.BOLD, 18));

        JComboBox majorBox = new JComboBox(majors[0]);  // 专业下拉框
        majorBox.setBounds(100, 150, 200, 40);
        majorBox.setFont(new Font("微软雅黑", Font.BOLD, 18));
        this.add(comboBoxPanel);

        academyBox.addActionListener(e -> {
            // 为学院下拉框添加监听事件
            majorBox.removeAllItems();
            int index = academyBox.getSelectedIndex();
            for (int i = 0; i < majors[index].length; i++) {
                majorBox.addItem(majors[index][i]);
            }
        });
        comboBoxPanel.add(academyBox);
        comboBoxPanel.add(majorBox);
    }

    public Combobox() {
        setSize(500, 500);
        setTitle("下拉菜单级联");
        setLayout(null);
        initComboBox();
        setVisible(true);
    }

    public static void main(String[] args) {
        Combobox cob = new Combobox();
    }
}
