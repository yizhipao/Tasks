1.开发工具：Intelij IDEA
  语言：java

2.运行环境：jdk

3.功能描述：根据年份来求存储器容量大致需求，还有位数预估存储器的价格

4.源代码文件说明： 

  private void button3ActionPerformed(ActionEvent e) {
        int c=Integer.parseInt(c1.getText());
        int y1=Integer.parseInt(y.getText());
        int cc=Integer.parseInt(mc.getText()) ;
        double ac;
        double m ;
        m=4080*Math.pow(2.7,0.28*(y1-1960));//根据年份算M
        ac = cc/(c*30)*m;
        l9.setText(""+ac+"$");
    }

    private void button1ActionPerformed(ActionEvent e) {
        int y1=Integer.parseInt(y.getText());
        double m ;
        m=4080*Math.pow(2.7,0.28*(y1-1960));
        l3.setText(""+m);

    }

    private void button2ActionPerformed(ActionEvent e) {
        int y1=Integer.parseInt(y.getText());
        double m ;
        m=4080*Math.pow(2.7,0.28*(y1-1960));
        int x=Integer.parseInt(cb.getItemAt(cb.getSelectedIndex()));
        double p = m*x*0.003*Math.pow(0.72,y1-1974);
        l5.setText(""+p+"$");
    }
算了，符老大，这个题我写不下去了。