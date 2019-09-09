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
