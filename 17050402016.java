package zuoye;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class j1_5 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					j1_5 frame = new j1_5();
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
	public j1_5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
		);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("第一（三）题", null, layeredPane, null);
		
		JLabel label = new JLabel("\u5728");
		label.setBounds(25, 16, 31, 18);
		layeredPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(40, 13, 42, 24);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5E74\u5BF9\u8BA1\u7B97\u673A\u7684\u5B58\u50A8\u91CF\u7684\u4F30\u8BA1\u9700\u6C42");
		lblNewLabel.setBounds(83, 16, 217, 18);
		layeredPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u662F");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double year=Integer.parseInt(textField.getText());
				double need=0;
				need=4080*(Math.exp(0.28*(year-1960)));
				textField_1.setText(String.valueOf(need));
			}
		});
		btnNewButton.setBounds(264, 12, 47, 27);
		layeredPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(317, 13, 170, 24);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B57\u3002");
		lblNewLabel_1.setBounds(487, 16, 38, 18);
		layeredPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u5982\u679C\u5B57\u957F\u4E3A");
		label_1.setBounds(25, 88, 83, 18);
		layeredPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 85, 23, 24);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F4D\uFF0C\u8FD9\u4E2A\u5B58\u50A8\u5668\u7684\u4EF7\u683C");
		lblNewLabel_2.setBounds(122, 88, 150, 18);
		layeredPane.add(lblNewLabel_2);
		
		JButton button = new JButton("\u662F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double year=Integer.parseInt(textField.getText());
				double bits=Integer.parseInt(textField_2.getText());
				double need,price=0;
				need=4080*(Math.exp(0.28*(year-1960)));
				price=bits*(year*0.003*Math.pow(0.72, (year-1974)));
				textField_3.setText(String.valueOf(price));
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(Color.RED);
		button.setBounds(253, 84, 47, 27);
		layeredPane.add(button);
		
		textField_3 = new JTextField();
		textField_3.setBounds(306, 85, 164, 24);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7F8E\u5143\u3002");
		label_2.setBounds(456, 88, 56, 18);
		layeredPane.add(label_2);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("第二（三）题", null, layeredPane_1, null);
		
		JLabel lblNewLabel_3 = new JLabel("\u5047\u8BBE\u5728");
		lblNewLabel_3.setBounds(14, 13, 45, 18);
		layeredPane_1.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(52, 10, 38, 24);
		layeredPane_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5E74\u4E00\u540D\u7A0B\u5E8F\u5458\u6BCF\u5929\u8BFE\u5F00\u53D1\u51FA");
		label_3.setBounds(94, 13, 186, 18);
		layeredPane_1.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(254, 10, 26, 24);
		layeredPane_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_4 = new JLabel("\u6761\u6307\u4EE4\uFF0C\u7A0B\u5E8F\u5458\u7684\u5E73\u5747\u5DE5\u8D44\u662F\u6BCF\u6708");
		label_4.setBounds(281, 13, 225, 18);
		layeredPane_1.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(480, 10, 66, 24);
		layeredPane_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_5 = new JLabel("\u7F8E\u5143\u3002\u5982\u679C\u4E00\u6761\u6307\u4EE4\u4E00\u4E2A\u5B57\u957F\uFF0C\u5219\u4F7F\u5B58\u50A8\u5668\u88C5\u6EE1\u7A0B\u5E8F\u6240\u9700\u7684\u6210\u672C");
		label_5.setBounds(0, 36, 420, 18);
		layeredPane_1.add(label_5);
		
		JButton button_1 = new JButton("\u4E3A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double year=Integer.parseInt(textField_4.getText());
				double instructions=Integer.parseInt(textField_5.getText());
				double salary=Integer.parseInt(textField_6.getText());
				double need,cost=0;
				need=4080*(Math.exp(0.28*(year-1960)));
				cost=(need/(30*instructions)*salary);
				textField_7.setText(String.valueOf(cost));
			}
		});
		button_1.setBackground(Color.RED);
		button_1.setForeground(Color.BLACK);
		button_1.setBounds(366, 32, 47, 27);
		layeredPane_1.add(button_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(413, 33, 133, 24);
		layeredPane_1.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7F8E\u5143\u3002");
		lblNewLabel_4.setBounds(0, 58, 72, 18);
		layeredPane_1.add(lblNewLabel_4);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
