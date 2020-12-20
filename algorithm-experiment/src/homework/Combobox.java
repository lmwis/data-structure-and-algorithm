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

    private static String[] academys = {"������Ϣ���˹�����ѧԺ", "�Ṥ��ѧ�빤��ѧԺ"};
    private static String[][] majors = {
            {"�������ѧ�뼼��", "���繤��", "������", "������Ϣ����", "���ӿ�ѧ�뼼��", "�����Ϣ���ѧ"},
            {"�ữ����", "ӡˢ���װ", "��֯��"}
    };

    private void initComboBox() {
        comboBoxPanel.setSize(400, 400);
        comboBoxPanel.setLocation(50, 80);
        comboBoxPanel.setLayout(null);
        JLabel academyLabel = new JLabel("ѧԺ");
        academyLabel.setBounds(20, 50, 50, 40);
        academyLabel.setFont(new Font("΢���ź�", Font.BOLD, 18));
        comboBoxPanel.add(academyLabel);

        JLabel majorLabel = new JLabel("רҵ");
        majorLabel.setBounds(20, 150, 50, 40);
        majorLabel.setFont(new Font("΢���ź�", Font.BOLD, 18));
        comboBoxPanel.add(majorLabel);

        JComboBox academyBox = new JComboBox(academys); // ѧԺ������
        academyBox.setBounds(100, 50, 200, 40);
        academyBox.setFont(new Font("΢���ź�", Font.BOLD, 18));

        JComboBox majorBox = new JComboBox(majors[0]);  // רҵ������
        majorBox.setBounds(100, 150, 200, 40);
        majorBox.setFont(new Font("΢���ź�", Font.BOLD, 18));
        this.add(comboBoxPanel);

        academyBox.addActionListener(e -> {
            // ΪѧԺ��������Ӽ����¼�
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
        setTitle("�����˵�����");
        setLayout(null);
        initComboBox();
        setVisible(true);
    }

    public static void main(String[] args) {
        Combobox cob = new Combobox();
    }
}
