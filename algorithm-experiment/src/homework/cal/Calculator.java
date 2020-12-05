package homework.cal;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-12-05 14:32
 * @Version 1.0
 */
public class Calculator extends JFrame {
    private JPanel panel1;//���1�������20����ť��5��4�У�
    private JButton[] buttons1;//���1�ϵİ�ť����

    private JPanel panel2;//���2�������4����ť��4��1�У�
    private JButton[] buttons2;//���2�ϵİ�ť����

    private JPanel panel3;//���3�������2����ť��1��2�У�
    private JButton[] buttons3;//���3�ϵİ�ť����

    private JPanel panel4;//���4�������1����ť��1��1�У�
    private JButton button4;

    private JPanel panel5;//���5�������1����ť��1��1�У�
    private JButton button5;

    private JPanel radioBtnPanel; //��ѡ��

    private JPanel optionPanel; //��ิ�Ӳ������
    private JButton[] optButtons;

    private void initMenu() {
        JLabel findLabel = new JLabel("�鿴(V)");
        findLabel.setBounds(20, 5, 80, 30);
        findLabel.setFont(new Font("΢���ź�", Font.BOLD, 16));
        this.add(findLabel);

        JLabel editLabel = new JLabel("�༭(E)");
        editLabel.setBounds(85, 5, 80, 30);
        editLabel.setFont(new Font("΢���ź�", Font.BOLD, 16));
        this.add(editLabel);

        JLabel helpLabel = new JLabel("����(H)");
        helpLabel.setBounds(165, 5, 80, 30);
        helpLabel.setFont(new Font("΢���ź�", Font.BOLD, 16));
        this.add(helpLabel);
    }

    private void initDisplay() {
        JTextField calText = new JTextField(20);
        calText.setBounds(20, 45, 650, 80);
        calText.setFont(new Font("΢���ź�", Font.BOLD, 16));
        this.add(calText);
    }

    private void initDegreeOption() {
        radioBtnPanel = new JPanel();
        radioBtnPanel.setSize(300, 30);
        radioBtnPanel.setLocation(20, 130);
        radioBtnPanel.setLayout(new GridLayout(1,3,2,2));
        ButtonGroup bg = new ButtonGroup();
        JRadioButton degreeBtn = new JRadioButton("��");
        JRadioButton radianBtn = new JRadioButton("����");
        JRadioButton gradientBtn = new JRadioButton("�ݶ�");

        degreeBtn.setFont(new Font("΢���ź�", Font.BOLD, 16));
        radianBtn.setFont(new Font("΢���ź�", Font.BOLD, 16));
        gradientBtn.setFont(new Font("΢���ź�", Font.BOLD, 16));

        bg.add(degreeBtn);
        bg.add(radianBtn);
        bg.add(gradientBtn);
        radioBtnPanel.add(degreeBtn);
        radioBtnPanel.add(radianBtn);
        radioBtnPanel.add(gradientBtn);
        this.add(radioBtnPanel);
    }

    private void initOptionPanel() {
        optionPanel = new JPanel();
        optionPanel.setSize(320, 280);
        optionPanel.setLocation(20, 180);
        optionPanel.setLayout(new GridLayout(5,5,2,2));
        String[] titles={" ","Inv","In","(",")","Int","sih","sin","x2","n!","dms","cosh","cos","xy","y��x","��","tanh","tan","x3","3x","F-E","Exp","Mod","log","10x"};
        optButtons=new JButton[25];
        for(int i=0;i<titles.length;i++)
        {
            optButtons[i]=new JButton(titles[i]);
//            optButtons[i].setFont(new Font("΢���ź�", Font.BOLD, 15));
            optionPanel.add(optButtons[i]);
        }
        this.add(optionPanel);
    }

    private void initPanel1()//��ʼ�����1�Լ�����Ŀؼ�
    {
        panel1=new JPanel();
        panel1.setSize(255, 280);
        panel1.setLocation(350, 125);
        panel1.setLayout(new GridLayout(5,4,2,2));
        String[] titles={"MC","MR","MS","M+","<-","CE","C","+-","7","8","9","/","4","5","6","*","1","2","3","-"};
        buttons1=new JButton[20];
        for(int i=0;i<titles.length;i++)
        {
            buttons1[i]=new JButton(titles[i]);
//            buttons1[i].setFont(new Font("΢���ź�", Font.BOLD, 15));
            panel1.add(buttons1[i]);
        }
        this.add(panel1);
    }

    private void initPanel2()//��ʼ�����2�Լ�����Ŀؼ�
    {
        panel2=new JPanel();
        panel2.setSize(65, 225);
        panel2.setLocation(606, 125);
        panel2.setLayout(new GridLayout(4,1,2,2));
        String[] titles={"M-","��","%","1/x"};
        buttons2=new JButton[4];
        for(int i=0;i<titles.length;i++)
        {
            buttons2[i]=new JButton(titles[i]);
            panel2.add(buttons2[i]);
        }
        this.add(panel2);
    }

    private void initPanel3()//��ʼ�����3�Լ�����Ŀؼ�
    {
        panel3=new JPanel();
        panel3.setSize(126, 53);
        panel3.setLocation(478, 406);
        panel3.setLayout(new GridLayout(1,2,2,2));
        String[] titles={".","+"};
        buttons3=new JButton[2];
        for(int i=0;i<titles.length;i++)
        {
            buttons3[i]=new JButton(titles[i]);
            panel3.add(buttons3[i]);
        }
        this.add(panel3);
    }

    private void initPanel4()//��ʼ�����4�Լ�����Ŀؼ�
    {
        panel4=new JPanel();
        panel4.setSize(65, 109);
        panel4.setLocation(606, 350);
        panel4.setLayout(new GridLayout(1,1,2,2));
        button4=new JButton("=");
        panel4.add(button4);
        this.add(panel4);
    }

    private void initPanel5()//��ʼ�����5�Լ�����Ŀؼ�
    {
        panel5=new JPanel();
        panel5.setSize(125, 52);
        panel5.setLocation(350, 407);
        panel5.setLayout(new GridLayout(1,1,2,2));
        button5=new JButton("0");
        panel5.add(button5);
        this.add(panel5);
    }
    public Calculator() {
        setSize(750,550);
        setTitle("������");
        setLayout(null);
        initMenu();
        initDisplay();
        initDegreeOption();
        initOptionPanel();
        initPanel1();
        initPanel2();
        initPanel3();
        initPanel4();
        initPanel5();
        setVisible(true);
    }
}