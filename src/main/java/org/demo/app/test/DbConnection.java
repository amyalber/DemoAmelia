package org.demo.app.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DbConnection {

	public Connection getConnection() 
	{	
	
		Connection conn = null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//lCiscoLife=DbConstants.LOCAL;
		
		
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root","Temp123$");
		
		//conn = DriverManager.getConnection("jdbc:mysql://10.24.112.23:3306/test", "root","cisco@Zensar2019");
		
		ResultSet rs=null;
		
			
		String str="select * from testvalues";
		
		Statement stmt=conn.createStatement();  
		 rs=stmt.executeQuery(str);  

		 while(rs.next())  
			 System.out.println("Test: "+rs.getString(1));  
		
		
		}
	 catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("Connection Class not found");
		 e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("DriverManager.getConnection not found");
		e.printStackTrace();
	}		
	
	return conn;
	}

	
	public static void main(String[] args) {
		DbConnection db = new DbConnection();
		db.getConnection();
	}
	
}
