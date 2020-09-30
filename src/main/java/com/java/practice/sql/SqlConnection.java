package com.java.practice.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnection {
	private static final String DATABASE_NAME = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	private static final String TABLE_NAME = "";
	public static void main(String args[]){  		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DATABASE_NAME+"?autoReconnect=true&useSSL=false",USERNAME,PASSWORD);	
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from "+TABLE_NAME);  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				con.close();  
			}catch(Exception e){ 
				System.out.println(e);			
			}  
		}  
}

/*Please include package or add maven dependency

<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.19</version>
</dependency>*/