1.开发工具：eclipse
  语言：java

2.运行环境：jdk

3.功能描述：根据年份来求存储器容量大致需求，还有位数预估存储器的价格

4.源代码文件说明： 
  第一题：
  btnNewButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                	Object integer;
					
					String i=textField_1.getText().trim();//获取输入年份
					 int v=Integer.parseInt(i);//将其转为int类型
					 v=(int) (4080*Math.pow(2.7,0.28*(v-1960)));//计算计算机存储容量需求估计
					 String x=""+v;
                    textField_3.setText(x);
                    String p=textField_1.getText().trim();
					 double k=Integer.parseInt(p);
					 k=(double) (v*0.048*Math.pow(0.72,(k-1974)));//计算存储器价格
					 String n=""+k;
                   textField_4.setText(n);
                } catch (Exception e2)
                {
                }
            }
  第二题：
  btnNewButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                	Object integer;
					//String i =  textField_1.getText();
                	String r=textField_3.getText().trim();//获取年份
					 int q=Integer.parseInt(r);
                	String i=textField_1.getText().trim();//获取指令数
					 int v=Integer.parseInt(i);
					 v=(int) (4080*Math.pow(2.7,0.28*(v-1960)));//计算所需成本
					 v=v/200*q;
					 String x=""+v;
                    textField_4.setText(x);
                    
                } catch (Exception e2)
                {
                }
            }

  第三题：基本算法与第一题和第二题一致
  	btnNewButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                	Object integer;
					
                	String r=textField_3.getText().trim();
					 int q=Integer.parseInt(r);
                	String i=textField_1.getText().trim();
					 int v=Integer.parseInt(i);
					 int oi=Integer.parseInt(i);
					
					 int pk=(int) (4080*Math.pow(2.7,0.28*(v-1960)));
					 oi=(int) (pk*0.048*Math.pow(0.72,(oi-1974)));
					 String x=""+pk;
					 String op=""+oi;
					 textField_8.setText(x);
					 textField_9.setText(op);
					 int nb=v;
					 nb=nb/200*q;
					 String xs=""+nb;
                    textField_4.setText(xs);
                    
                } catch (Exception e2)
                {
                }
            }