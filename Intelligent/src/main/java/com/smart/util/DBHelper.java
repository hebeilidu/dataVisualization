package com.smart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {

	public static Connection getConn() {

		String uri= "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=smart";
		Connection con=null;
   	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    //加载驱动
			con = DriverManager.getConnection(uri, "sa", "123456");    //获取数据库连接对象
			//System.out.println("连接数据库成功！！！");
		 } catch (Exception e) 
		 {
			e.printStackTrace();
		 }
   	    return con;

	}

}
