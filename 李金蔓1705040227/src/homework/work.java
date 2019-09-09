package homework;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.math.*;

@SuppressWarnings("unused")
class js{
	double rlfunc(int y){
		double M=0;//容量需求
		double a=0;
		a=Math.exp(0.28*(y-1960));
		M=4080*a;
		return M;
	}
	double jgfunc(int x,int y) {//计算存储器价格
		double P=0;
		if(x==16) {
			P=0.048*Math.pow(0.72, y-1974);
		}else {
			P=0.3*Math.pow(0.72, y-1974);
		}	
		return P;
	}
	double cbfunc(int x,int y) {//计算成本
		double C=0;
		double A,B,D;
		A=0;
		B=0;
		D=0;
		A=this.jgfunc(x, y);//存储器价格
		B=this.rlfunc(y);//容量
		if(x==32) {//程序员工资6000刀
			A=A/10;
			D=(B/32)/30;
			C=A+(D/30)*6000;
		}else {//程序员工资4000刀
			if(x==16) {
				D=(B/16)/10;
				C=A+(D/30)*4000;
			}else {
				A=A/10;
				D=(B/8)/10;
				C=A+(D/30)*4000;
			}
		}
		return C;
	}
}
class jieguowindow extends JFrame{//结果输出界面
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	jieguowindow(double x,double y,double z) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u67E5 \u8BE2 \u7ED3 \u679C");
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(155)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u5199\u6EE1\u7A0B\u5E8F\u7684\u6210\u672C\uFF1A");
		panel_2.add(lblNewLabel_1);
		
		JTextField textField_2 = new JTextField();//成本
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BB9\u91CF\uFF1A");
		panel_1.add(label_1);
		
		textField_1 = new JTextField();//容量
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5B58\u50A8\u5668\u4EF7\u683C\uFF1A");
		panel.add(lblNewLabel);
		
		textField = new JTextField();//存储器价格
		panel.add(textField);
		textField.setColumns(10);
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
		textField_1.setText(Double.toString(x));
		textField.setText(Double.toString(y));
		textField_2.setText(Double.toString(z));
	}
}
public class work extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//主界面
	private JPanel contentPane;
	private JTextField textField;
    String nf;
    String wei;
    String cha;
    int Y;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					work frame = new work();
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
	public work() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("\u8F93\u5165\u60F3\u67E5\u8BE2\u7684\u5E74\u4EFD\uFF1A");
		
		textField = new JTextField();
		textField.setColumns(10);
		//textField.setText("1985");
		JLabel label_1 = new JLabel("\u67E5\u8BE2\u7684\u5B58\u50A8\u5668\u4E00\u5B57\u51E0\u4F4D");
		
		JButton button = new JButton("\u786E\u8BA4\u67E5\u8BE2");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"8","16", "32"}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(202)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(158)
							.addComponent(button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_1)))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label_1)
							.addGap(13)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(90)
					.addComponent(button)
					.addGap(29))
		);
		
		
		
		button.addActionListener(new ActionListener(){//打开输出结果的鼠标监听器

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				wei=(String)comboBox_1.getSelectedItem();
				nf=textField.getText();
		try {
			if(nf!=null) {
			Y=Integer.parseInt(nf);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
				js js_1=new js();
				int x=0;
				if(wei.equals("16")==true) {
					x=16;
					
				}else {
					if(wei.equals("8")==true)
						x=8;
					if(wei.equals("32")==true)
						x=32;
				}
				jieguowindow frame=new jieguowindow(js_1.rlfunc(Y),js_1.jgfunc(x, Y),js_1.cbfunc(x, Y));
				
				frame.setVisible(true);
			}
			
		});
		contentPane.setLayout(gl_contentPane);
	}
}
