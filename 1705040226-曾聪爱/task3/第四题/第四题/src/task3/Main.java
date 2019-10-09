package task3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Main {
	Dbprocess db = new Dbprocess();
	public Main() {
		
	}
	
	public void Algorithm_A() {
		if(db.createConn()) {
			db.update("insert into new select * from old;");
			db.query("select * from old where salary<26000;");
			while(db.next()) {
				int id = db.getInt("id");
				Date date = db.getDate("date");
				int feed = db.getInt("feed");
				int tempsalary = db.getInt("salary");
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				int year = c.get(Calendar.YEAR);
				tempsalary += feed * 100 + (2019-year)*50;
				if(tempsalary >= 26000) {
					db.update("update new set salary = 26000 where id = " + id + ";");
				}else {
					db.update("update new set salary = " + tempsalary +" where id = " + id + ";");
				}
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}else {
			System.out.println("数据库连接失败");
		}
	}
	
	public void Algorithm_B() {
		if(	db.createConn()) {
			db.update("insert into new select * from old;");
			System.out.println("b");
			db.query("select * from old order by asc ;");
			while(db.next()) {
				int tempsalary = db.getInt("salary");
				if(tempsalary>=26000) {
					continue;
				}
				int id = db.getInt("id");
				Date date = db.getDate("date");
				int feed = db.getInt("feed");
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				int year = c.get(Calendar.YEAR);
				tempsalary += feed * 100 + (2019-year)*50;
				if(tempsalary >= 26000) {
					db.update("update new set salary = 26000 where id = " + id + ";");
				}else {
					db.update("update new set salary = " + tempsalary +" where id = " + id + ";");
				}
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}else {
			System.out.println("数据库连接失败");
		}
	}
	
	public boolean logout(String filename) throws IOException {
		int rownum=  0;
		if(!db.createConn()) {
			System.out.println("数据库连接失败");
			return false;
		}
		db.query("select count(*) from new;");
		db.next();
		int maxid = db.getInt("count(*)");
		db.closeStmt();
		db.closeRs();
		db.query("select new.id,new.name,new.salary,old.salary from new,old where new.id = old.id;");
		File log = new File("C:\\Users\\Administrator\\Desktop\\" + filename + ".xls");
		 //创建工作薄对象
		HSSFWorkbook workbook=new HSSFWorkbook();//这里也可以设置sheet的Name
		//创建工作表对象
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0,"新旧工资对比表");//设置sheet的Name
		//创建工作表的行
		HSSFRow row[] = new HSSFRow[maxid];
		System.out.println(maxid);
		while(db.next()) {
			System.out.println(rownum);
			row[rownum] = sheet.createRow(rownum);//设置第一行，从零开始
			int id = db.getInt("new.id");
			String name = db.getString("new.name");
			int newsalary = db.getInt("new.salary");
			int oldsalary = db.getInt("old.salary");
			row[rownum].createCell(0).setCellValue(id);
			row[rownum].createCell(1).setCellValue(name);
			row[rownum].createCell(2).setCellValue(newsalary);
			row[rownum++].createCell(3).setCellValue(oldsalary);
		}
		//文档输出
		FileOutputStream out = new FileOutputStream(log);
		workbook.write(out);
		out.close();
		workbook.close();
		return true;
	}
	
	public void rollback() {
		if(!db.createConn()) {
			System.out.println("数据库连接失败");
		}else {
			db.update("truncate new;");
		}
	}
}
