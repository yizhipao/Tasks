# task1  

> 1705040223 郭满

## 开发工具，语言  
    eclipse  
    java  

## 运行环境  
    jre+win10  

## 功能描述  
    计算计算机存储容量随时间推移的需求，存储器的价格和是存储器装满程序所需用的成本  

## 源代码文件说明  
    pipi.java  
    一个窗体，四个输入框，一个按钮，三个输出框，计算所求信息  
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