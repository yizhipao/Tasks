package zuoye;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JLabel;

public class pp {

	private JFrame frame;
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
					pp window = new pp();
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
	public pp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7B2C\u4E00\u7AE0\u7B2C\u4E94\u9898");
		frame.setBounds(100, 100, 514, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_97762122033851");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setToolTipText("");
		tabbedPane.addTab("第一小题", null, layeredPane_1, null);
		
		textField = new JTextField();
		textField.setBounds(191, 13, 170, 24);
		layeredPane_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 37, 170, 24);
		layeredPane_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5B58\u50A8\u9700\u6C42");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double s1=Integer.parseInt(textField.getText());
				double result=0;
				result=4080*(Math.exp(0.28*(s1-1960)));
				textField_4.setText(String.valueOf(result));
			}
		});
		btnNewButton.setBounds(37, 146, 136, 27);
		layeredPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5B58\u50A8\u5668\u4EF7\u683C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double s1=Integer.parseInt(textField.getText());
				double s2=Integer.parseInt(textField_1.getText());
				double result,result1=0;
				result=4080*(Math.exp(0.28*(s1-1960)));
				result1=s2*(result*0.003*Math.pow(0.72, (s1-1974)));
				textField_5.setText(String.valueOf(result1));
			}

		});
		btnNewButton_1.setBounds(319, 146, 136, 27);
		layeredPane_1.add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(37, 173, 136, 27);
		layeredPane_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(319, 174, 136, 24);
		layeredPane_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5E74\u4EFD");
		lblNewLabel.setBounds(117, 16, 72, 18);
		layeredPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B57\u957F");
		lblNewLabel_1.setBounds(117, 40, 72, 18);
		layeredPane_1.add(lblNewLabel_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("第二小题", null, layeredPane, null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(250, 13, 134, 24);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(250, 50, 134, 24);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u88C5\u6EE1\u5B58\u50A8\u5668\u6240\u9700\u6210\u672C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double s1=Integer.parseInt(textField_2.getText());
				double s2=Integer.parseInt(textField_3.getText());
				double s3=Integer.parseInt(textField_7.getText());
				double result,result1=0;
				result=4080*(Math.exp(0.28*(s1-1960)));
				result1=(result/(30*s2)*s3);
				textField_6.setText(String.valueOf(result1));
			}
		});
		btnNewButton_2.setBounds(154, 175, 176, 27);
		layeredPane.add(btnNewButton_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(154, 215, 175, 24);
		layeredPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(250, 87, 134, 24);
		layeredPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74\u4EFD");
		lblNewLabel_2.setBounds(128, 16, 72, 18);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6BCF\u5929\u5F00\u53D1\u6307\u4EE4\u6570");
		lblNewLabel_3.setBounds(99, 53, 113, 18);
		layeredPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7A0B\u5E8F\u5458\u5DE5\u8D44");
		lblNewLabel_4.setBounds(109, 90, 103, 18);
		layeredPane.add(lblNewLabel_4);
		panel.setLayout(gl_panel);
	}
}
