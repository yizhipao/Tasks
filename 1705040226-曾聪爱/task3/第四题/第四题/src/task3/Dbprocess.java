package task3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbprocess {
	private String drv = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/ts?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
	private String usr = "root";
	private String pwd = "housong1949";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public String getDrv(){return drv;}
	public void setDrv(String drv){this.drv = drv;}
	
	public String getUrl(){return url;}
	public void setUrl(String url){this.url = url;}
	
	public String getUsr(){return usr;}
	public void setUsr(String usr){this.usr = usr;}
	
	public String getPwd(){return pwd;}
	public void setPwd(String pwd){this.pwd = pwd;}
	
    public Connection getConn(){return conn;}
	public void setConn(Connection conn){this.conn = conn;}
	
	public Statement getStmt(){return stmt;}
	public void setStmt(Statement stmt){this.stmt = stmt;}
	
	public ResultSet getRs(){return rs;}
	public void setRs(ResultSet rs){this.rs = rs;}
	
	public boolean createConn(){
		boolean b = false;
		try{
			Class.forName(drv).newInstance();
			conn = DriverManager.getConnection(url,usr,pwd);
			b = true;
		}catch(SQLException e){
			System.out.println("1");
		}
		 catch(ClassNotFoundException e){
			 System.out.println("2");
		 }
		 catch(InstantiationException e){
			 System.out.println("3");
		 }
		 catch(IllegalAccessException e){
			 System.out.println("4");
		 }
		return b;
	}
	
	public boolean update(String sql){
		boolean b = false;
		try{
			stmt = conn.createStatement();
			stmt.execute(sql);
			b = true;
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return b;
	}
	
	public void query(String sql){
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		}catch(Exception e){}
	}
	
	public boolean next(){
		boolean b = false;
		try{
			if(rs.next())
				b = true;
		}catch(Exception e){}
		return b;
	}
	
	public String getString(String field){
		String value = null;
		try{
			if(rs!=null)
				value = rs.getString(field);
		}catch(Exception e){}
		return value;
	}
	
	public Date getDate(String field){
		Date value = null;
		try{
			if(rs!=null)
				value = rs.getDate(field);
		}catch(Exception e){}
		return value;
	}
	
	public int getInt(String field){
		int value = 0;
			if(rs!=null) {
				try {
					value = rs.getInt(field);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return value;
	}
	
	public int getInt(int num){
		int value = 0;
		try{
			if(rs!=null) {
				value = rs.getInt(num);
			}
		}catch(Exception e){
			System.out.println("null");
		}
		return value;
	}
	
	public void closeConn(){
		try{
			if(conn != null)
				conn.close();
		}catch(SQLException e){}
	}
	
	public void closeStmt(){
		try{
			if(stmt != null)
				stmt.close();
		}catch(SQLException e){}
	}
	
	public void closeRs(){
		try{
			if(rs != null)
				rs.close();
		}catch(SQLException e){}
	}
}
