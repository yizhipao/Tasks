package task3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class GUI {

	private JFrame frame;
	public Main m;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		m = new Main();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btna = new JButton("计算的数据");
		btna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m.Algorithm_A();
			}
		});
		btna.setBounds(200, 70, 113, 27);
		frame.getContentPane().add(btna);
		
		JButton button = new JButton("打印工资目录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.logout(textField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(143, 213, 133, 27);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("请输入打印文件名称");
		textField.setBounds(98, 176, 223, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("文件将会生成到桌面上");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(98, 145, 223, 18);
		frame.getContentPane().add(label);
		
		JButton button_1 = new JButton("数据回滚");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.rollback();
			}
		});
		button_1.setBounds(305, 213, 113, 27);
		frame.getContentPane().add(button_1);
	}
}
