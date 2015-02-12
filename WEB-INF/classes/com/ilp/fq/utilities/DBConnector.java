package com.ilp.fq.utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {

	static final String jdbc_driver="oracle.jdbc.OracleDriver";
	static final String db_url="jdbc:oracle:thin:@172.25.192.71:1521:javadb";
	static final String user="H88ORAUSER2D";
	static final String pass="tcshyd";

	public static Connection getConnection() throws Exception {
		
		try {
			Class.forName(jdbc_driver);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}

		
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(db_url,user,pass);
			
			}
		 catch (SQLException e) {
			
			e.printStackTrace();

		}
		if (connection != null) {
			
			return connection;
		} else {
			System.out.println("Failed to make connection!");
		}
	 return connection;

	}
	
	public static void close(Connection con) throws Exception{
		
		con.close();
		
	}
	

}
