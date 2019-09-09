package hahaha;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class pipi {

	protected Shell shell;
	private Text txt_year;
	private Text txt_bit_number;
	private Text txt_payment;
	private Text txt_instructions;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			pipi window = new pipi();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */

	protected void createContents() {
		shell = new Shell();
		shell.setSize(600, 500);
		shell.setText("SWT Application");
		shell.setLayout(new FormLayout());
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("\u5E74\u4EFD");
		
		txt_year = new Text(shell, SWT.BORDER);
		fd_lblNewLabel.top = new FormAttachment(txt_year, 3, SWT.TOP);
		fd_lblNewLabel.right = new FormAttachment(txt_year, -75);
		FormData fd_text = new FormData();
		fd_text.top = new FormAttachment(0, 74);
		fd_text.left = new FormAttachment(0, 279);
		txt_year.setLayoutData(fd_text);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_1 = new FormData();
		fd_lblNewLabel_1.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		lblNewLabel_1.setLayoutData(fd_lblNewLabel_1);
		lblNewLabel_1.setText("\u5B57\u957F");
		
		txt_bit_number = new Text(shell, SWT.BORDER);
		fd_lblNewLabel_1.top = new FormAttachment(txt_bit_number, 3, SWT.TOP);
		FormData fd_text_1 = new FormData();
		fd_text_1.top = new FormAttachment(txt_year, 6);
		fd_text_1.left = new FormAttachment(txt_year, 0, SWT.LEFT);
		txt_bit_number.setLayoutData(fd_text_1);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_2 = new FormData();
		fd_lblNewLabel_2.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		lblNewLabel_2.setLayoutData(fd_lblNewLabel_2);
		lblNewLabel_2.setText("\u6307\u4EE4");
		
		txt_payment = new Text(shell, SWT.BORDER);
		fd_lblNewLabel_2.top = new FormAttachment(txt_payment, 3, SWT.TOP);
		FormData fd_text_2 = new FormData();
		fd_text_2.top = new FormAttachment(txt_bit_number, 6);
		fd_text_2.right = new FormAttachment(txt_year, 0, SWT.RIGHT);
		txt_payment.setLayoutData(fd_text_2);
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_3 = new FormData();
		fd_lblNewLabel_3.left = new FormAttachment(lblNewLabel, 0, SWT.LEFT);
		lblNewLabel_3.setLayoutData(fd_lblNewLabel_3);
		lblNewLabel_3.setText("\u5DE5\u8D44");
		
		txt_instructions = new Text(shell, SWT.BORDER);
		fd_lblNewLabel_3.top = new FormAttachment(txt_instructions, 3, SWT.TOP);
		FormData fd_text_3 = new FormData();
		fd_text_3.top = new FormAttachment(txt_payment, 6);
		fd_text_3.left = new FormAttachment(txt_year, 0, SWT.LEFT);
		txt_instructions.setLayoutData(fd_text_3); 
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(txt_instructions, 34);
		fd_btnNewButton.left = new FormAttachment(0, 213);
		fd_btnNewButton.right = new FormAttachment(0, 318);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("\u8BA1\u7B97");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_4 = new FormData();
		fd_lblNewLabel_4.top = new FormAttachment(lblNewLabel_3, 98);
		fd_lblNewLabel_4.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		lblNewLabel_4.setLayoutData(fd_lblNewLabel_4);
		lblNewLabel_4.setText("\u5BB9\u91CF");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_5 = new FormData();
		fd_lblNewLabel_5.top = new FormAttachment(lblNewLabel_4, 23);
		fd_lblNewLabel_5.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		lblNewLabel_5.setLayoutData(fd_lblNewLabel_5);
		lblNewLabel_5.setText("\u4EF7\u683C");
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_6 = new FormData();
		fd_lblNewLabel_6.top = new FormAttachment(lblNewLabel_5, 22);
		fd_lblNewLabel_6.right = new FormAttachment(lblNewLabel, 0, SWT.RIGHT);
		lblNewLabel_6.setLayoutData(fd_lblNewLabel_6);
		lblNewLabel_6.setText("\u6210\u672C");
		
		Label lb_memory = new Label(shell, SWT.NONE);
		FormData fd_lb_memory = new FormData();
		fd_lb_memory.right = new FormAttachment(txt_year, 49, SWT.RIGHT);
		fd_lb_memory.left = new FormAttachment(txt_year, -61);
		fd_lb_memory.top = new FormAttachment(lblNewLabel_4, 0, SWT.TOP);
		lb_memory.setLayoutData(fd_lb_memory);
		
		Label price = new Label(shell, SWT.NONE);
		FormData fd_price = new FormData();
		fd_price.left = new FormAttachment(lb_memory, 0, SWT.LEFT);
		fd_price.right = new FormAttachment(lb_memory, 0, SWT.RIGHT);
		fd_price.bottom = new FormAttachment(lblNewLabel_5, 0, SWT.BOTTOM);
		price.setLayoutData(fd_price);
		price.setText(" ");
		
		Label cost = new Label(shell, SWT.NONE);
		FormData fd_cost = new FormData();
		fd_cost.left = new FormAttachment(lb_memory, 0, SWT.LEFT);
		fd_cost.right = new FormAttachment(lb_memory, 0, SWT.RIGHT);
		fd_cost.bottom = new FormAttachment(lblNewLabel_6, 0, SWT.BOTTOM);
		cost.setLayoutData(fd_cost);
	
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				calculate(lb_memory, price, cost);
			}
		});
		
	}
	public void calculate(Label lb_memory, Label price, Label cost) {
		double M,P,C;
		int year, bit_number, payment, instructions;
		year = Integer.valueOf(txt_year.getText());
		bit_number = Integer.valueOf(txt_bit_number.getText());
		payment = Integer.valueOf(txt_payment.getText());
		instructions = Integer.valueOf(txt_instructions.getText());		
		M = 4080.00 * Math.exp(0.28 * (year - 1960));
		lb_memory.setText(Double.toString(M));
		P = 0.30 * Math.pow(0.72, (year - 1974)) / 100.00 * bit_number;
		price.setText(Double.toString(P));
		C = M / (payment * 30) * instructions; 
		cost.setText(Double.toString(C));
	}
}
