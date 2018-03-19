package com.dataBase;

//不管连接的数据库是什么，都需要导入java.sql包中的相应的类
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class DataProcess {
	private String url="jdbc:sqlserver://USER-20151012:1433;" +
            "databaseName=shopping;"; //数据库服务器的位置
	private String user="sa"; //登陆数据库服务器的用户名
	private String password="sasasa";//登陆数据库服务器的密码
	private Connection conn=null;
	private Statement stm=null;
	private ResultSet rst=null;
	
	//获取数据，sql是select语句,rows存表的记录
	public Vector<Vector<String>> getData(String sql){
		Vector<Vector<String>> rows=new Vector<Vector<String>>(); //记录的集合
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //加载数据库驱动
			conn=DriverManager.getConnection(url, user, password);//获取连接
			stm=conn.createStatement();//创建执行sql语句的容器
			rst=stm.executeQuery(sql); //执行sql语句
			Vector<String> row=null; //保存一条记录
			ResultSetMetaData rsmd=rst.getMetaData();
			int col=rsmd.getColumnCount();
			while(rst.next()){
				row=new Vector<String>(); //每条记录对应的是一个Vector对象row
				for(int i=0;i<col;i++){//循环列
					row.add(rst.getString(i+1));
				}
				
				rows.add(row);
			}
			
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		
		return rows;
	}
	
	//添加删除更新数据，sql是insert、delete、update语句
	public boolean update(String sql){
		boolean b=false;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //加载数据库驱动
			conn=DriverManager.getConnection(url, user, password);//获取连接
			stm=conn.createStatement();//创建执行sql语句的容器
			stm.executeUpdate(sql); //执行sql语句
			b=true;
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return b;
	}
}
