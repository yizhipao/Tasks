# The first homework

----

## 开发工具及语言

     此次运用的开发工具为IntelliJ IDEA，语言为Java。

## 运行环境

     Windows下均可运行

## 功能描述

     运行tendency.exe文件，通过输入年份、程序员平均工资、每天可开发指令条数以及计算机字长等数据，计算出对计算机存储容量的需求、存储器价格使存储器装满程序所需用成本。

## 源代码文件说明

### main.java用于显示主窗口


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

    //初始化界面
    private void initialize() {
        frame = new JFrame("计算机硬件和软件成本变化");
        frame.setBounds(600, 150, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

    //将输入输出标签以及“确定”和“重置”按钮进行初始化，并且添加到窗口中
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

### test.java用于进行数据以及按钮的处理
    package cn.test;

    import javax.swing.*;

    public class test{
    static void button2() {
        main.years.setText(null);
        main.command.setText(null);
        main.word.setText(null);
        main.salary.setText(null);
        main.requirement.setText(null);
        main.stroage_price.setText(null);
        main.cost.setText(null);
    }
    static void button1() {
        if(main.years.getText().isEmpty()) {
            JOptionPane.showMessageDialog(main.frame, "年份不能为空", "提示", 1);
            button2();
        }else{
            if(main.word.getText().isEmpty()) {
                int years = Integer.valueOf(main.years.getText());
                int temp_M = (int) (4080*Math.pow(Math.E, 0.28*(years-1960)));
                main.requirement.setText(String.valueOf(temp_M)+"字");
            }else {
                if(main.salary.getText().isEmpty()& main.command.getText().isEmpty()) {
                    int years = Integer.valueOf(main.years.getText());
                    int word = Integer.valueOf(main.word.getText());
                    int temp_M = (int) (4080*Math.pow(Math.E, 0.28*(years-1960)));
                    int temp_P1 = (int) (temp_M*word*0.3*Math.pow(0.72, (years-1974)));
                    main.requirement.setText(String.valueOf(temp_M)+"字");
                    main.stroage_price.setText(String.valueOf(temp_P1)+"美元");
                }else {
                    if(main.salary.getText().isEmpty()| main.command.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(main.frame, "缺少数据", "提示", 1);
                    }else {
                        int years = Integer.valueOf(main.years.getText());
                        int command = Integer.valueOf(main.command.getText());
                        int word = Integer.valueOf(main.word.getText());
                        int salary = Integer.valueOf(main.salary.getText());
                        int temp_M = (int) (4080*Math.pow(Math.E, 0.28*(years-1960)));
                        int temp_P1 = (int) (temp_M*word*0.3*Math.pow(0.72, (years-1974)));
                        int temp_cost = salary*(temp_M/30/command);
                        main.requirement.setText(String.valueOf(temp_M)+"字");
                        main.stroage_price.setText(String.valueOf(temp_P1)+"美元");
                        main.cost.setText(String.valueOf(temp_cost)+"美元");
                    }
                }
            }
        }
    }
    }

