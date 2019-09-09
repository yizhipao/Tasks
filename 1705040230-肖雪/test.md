# 开发工具、语言

------

> * Eclipse
> * java

------

# 运行环境
------

> * JRE

------


#功能描述


----------

> 这个test程序是用来计算每年对计算机存储容量的需求估计值、存储器的价格以及使存储器装满程序所需要的成本。通过文本框输入所要计算的年份可以得出计算机容量的需求估计和存储器的价格。再输入指令数和程序员的月平均工资可以计算出成本。


----------

#代码


    package xiaoa;
    
    import java.awt.BorderLayout;
    import java.awt.EventQueue;
    
    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.border.EmptyBorder;
    import javax.swing.JLabel;
    import java.awt.Color;
    import java.awt.Font;
    import javax.swing.JComboBox;
    import javax.swing.JButton;
    import java.awt.event.ActionListener;
    import java.awt.event.ActionEvent;
    import javax.swing.JTextField;
    import javax.swing.GroupLayout;
    import javax.swing.GroupLayout.Alignment;
    import com.jgoodies.forms.factories.DefaultComponentFactory;
    import javax.swing.LayoutStyle.ComponentPlacement;
    import javax.swing.DefaultComboBoxModel;
    
    public class xia extends JFrame {
    
    	private JPanel contentPane;
    	private JTextField textField_2;
    	private JTextField textField;
    	private JTextField textField_3;
    	private JTextField textField_1;
    	private JTextField textField_4;
    
    	/**
	 * Launch the application.
	 */
    //创建窗口
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xia frame = new xia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public xia() {

    //在窗口里添加插件及设置大小位置格式等


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setForeground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel label = new JLabel("\u8F93\u5165\u9700\u8981\u8BA1\u7B97\u7684\u5E74\u4EFD");
		label.setFont(new Font("幼圆", Font.PLAIN, 18));
		label.setForeground(new Color(34, 139, 34));
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("幼圆", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u9009\u62E9\u8BA1\u7B97\u9700\u8981", "M", "cost", "price"}));
		comboBox.setForeground(new Color(34, 139, 34));
		comboBox.setToolTipText("");
		
		textField_2 = new JTextField();
		
		textField = new JTextField();
                    		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		
		JButton btnp = new JButton("\u786E\u8BA4\u8BA1\u7B97");


       //对button写监听器，即计算部分
		btnp.addActionListener(new ActionListener() {

  
			public void actionPerformed(ActionEvent e) {
				
     `  //通过下拉框进行选择需要计算的值`

        //如果是M计算计算机存储容量的需求，cost计算所需成本，price计算存储器价格。`
    
		String a=(String) comboBox.getSelectedItem();
	    double y=Double.parseDouble(textField.getText());
				if(a=="M")
				{ 
					double m=4080*Math.pow(Math.E, 0.28*(y-1960));
					textField_2.setText(String.valueOf(String.format("%.3f", m)));}
				
				   else if(a=="cost")
				{
					  
					   double m=4080*Math.pow(Math.E, 0.28*(y-1960));
					   double z=Double.parseDouble(textField_1.getText());
					   double g=Double.parseDouble(textField_4.getText());
					   double p=m/(z*20)*g;	
					textField_2.setText(String.valueOf(String.format("%.3f", p)));
						}
					
				else if(a=="price") {
					double m=4080*Math.pow(Math.E, 0.28*(y-1960));
					double q=0.048*Math.pow(0.72, y-1974)*m;
					textField_2.setText(String.valueOf(String.format("%.3f", q)));
				}
				else  
				{
					textField_2.setText(" ");
				}
			}
			
		});
		btnp.setForeground(new Color(34, 139, 34));
		btnp.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		
		
		JLabel label_1 = new JLabel("\u8BA1\u7B97\u7ED3\u679C\u770B\u8FD9\u91CC");
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblme = new JLabel("\u8BA1\u7B97\u673A\u5B58\u50A8\u5BB9\u91CF\u9010\u5E74\u589E\u52A0\uFF1AM=4080e^0.28(Y-1960)");
		lblme.setForeground(new Color(0, 0, 0));
		lblme.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblpx = new JLabel("\u5B58\u50A8\u5668\u4EF7\u683C\u9010\u5E74\u4E0B\u964D\uFF1AP1=0.3x0.72^(Y-1974\uFF09");
		lblpx.setForeground(Color.BLACK);
		lblpx.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblpx_1 = new JLabel("\u8BA1\u7B97\u673A\u5B57\u957F16\u4F4D\uFF0C\u5B58\u50A8\u5668\u4EF7\u683C\u4E0B\u964D\u8D8B\u52BF\uFF1AP2=0.048x0.72^\uFF08Y-1974\uFF09");
		lblpx_1.setForeground(Color.BLACK);
		lblpx_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u6307\u4EE4\u6570\uFF08/\u5929/\u4EBA\uFF09");
		label_2.setForeground(new Color(34, 139, 34));
		label_2.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		
		
		JLabel label_3 = new JLabel("\u6708\u5DE5\u8D44");
		label_3.setForeground(new Color(34, 139, 34));
		label_3.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(290, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblpx_1, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(lblme, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblpx, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_2)
							.addGap(3)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
								.addComponent(btnp, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
					.addGap(183))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblme, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblpx, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblpx_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnp, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
