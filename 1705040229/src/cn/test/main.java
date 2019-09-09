package cn.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    static JFrame frame;
    static JTextField years;
    static JTextField command;
    static JTextField word;
    static JTextField salary;
    static JTextField requirement;
    static JTextField stroage_price;
    static JTextField cost;

    public main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("计算机硬件和软件成本变化");
        frame.setBounds(600, 150, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label_years = new JLabel("年份");
        label_years.setFont(new Font("楷书", Font.PLAIN, 20));
        label_years.setHorizontalAlignment(SwingConstants.CENTER);
        label_years.setBounds(30, 77, 72, 24);
        frame.getContentPane().add(label_years);

        years = new JTextField();
        years.setBounds(110, 80, 80, 25);
        frame.getContentPane().add(years);
        years.setColumns(10);

        JLabel label_word = new JLabel("字长");
        label_word.setFont(new Font("楷书", Font.PLAIN, 20));
        label_word.setHorizontalAlignment(SwingConstants.CENTER);
        label_word.setBounds(210, 75, 72, 35);
        frame.getContentPane().add(label_word);

        word = new JTextField();
        word.setColumns(10);
        word.setBounds(290, 80, 80, 25);
        frame.getContentPane().add(word);

        JLabel label_command = new JLabel("指令");
        label_command.setFont(new Font("楷书", Font.PLAIN, 20));
        label_command.setHorizontalAlignment(SwingConstants.CENTER);
        label_command.setBounds(390, 75, 72, 35);
        frame.getContentPane().add(label_command);

        command = new JTextField();
        command.setColumns(10);
        command.setBounds(470, 80, 80, 25);
        frame.getContentPane().add(command);

        JLabel label_salary = new JLabel("工资");
        label_salary.setFont(new Font("楷书", Font.PLAIN, 20));
        label_salary.setHorizontalAlignment(SwingConstants.CENTER);
        label_salary.setBounds(560, 75, 98, 35);
        frame.getContentPane().add(label_salary);

        salary = new JTextField();
        salary.setColumns(10);
        salary.setBounds(650, 80, 80, 25);
        frame.getContentPane().add(salary);

        JButton button1 = new JButton("确定");
        button1.setFont(new Font("楷书", Font.PLAIN, 20));
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                test.button1();
            }
        });
        button1.setBounds(150, 200, 110, 40);
        frame.getContentPane().add(button1);

        JButton button2 = new JButton("重置");
        button2.setFont(new Font("楷书", Font.PLAIN, 20));
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                test.button2();
            }
        });
        button2.setBounds(520, 200, 110, 40);
        frame.getContentPane().add(button2);

        JLabel label_requirement = new JLabel("容量需求");
        label_requirement.setFont(new Font("楷书", Font.PLAIN, 20));
        label_requirement.setHorizontalAlignment(SwingConstants.CENTER);
        label_requirement.setBounds(25, 300, 120, 25);
        frame.getContentPane().add(label_requirement);

        requirement = new JTextField();
        requirement.setEditable(false);
        requirement.setColumns(10);
        requirement.setBounds(140, 300, 110, 24);
        frame.getContentPane().add(requirement);

        JLabel label_stroage_price = new JLabel("存储器价格");
        label_stroage_price.setFont(new Font("楷书", Font.PLAIN, 20));
        label_stroage_price.setHorizontalAlignment(SwingConstants.CENTER);
        label_stroage_price.setBounds(280, 300, 120, 25);
        frame.getContentPane().add(label_stroage_price);

        stroage_price = new JTextField();
        stroage_price.setEditable(false);
        stroage_price.setColumns(10);
        stroage_price.setBounds(420, 300, 110, 24);
        frame.getContentPane().add(stroage_price);

        JLabel label_cost = new JLabel("成本");
        label_cost.setFont(new Font("楷书", Font.PLAIN, 20));
        label_cost.setHorizontalAlignment(SwingConstants.CENTER);
        label_cost.setBounds(550, 300, 72, 25);
        frame.getContentPane().add(label_cost);

        cost = new JTextField();
        cost.setEditable(false);
        cost.setColumns(10);
        cost.setBounds(630, 300, 120, 24);
        frame.getContentPane().add(cost);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main window = new main();
                    main.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
