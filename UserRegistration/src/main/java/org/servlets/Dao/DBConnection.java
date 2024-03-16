package org.servlets.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public DBConnection() {
		try {
			Class.forName("con.mysql.cj.jdbc.Driver");
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","admin123");
    }
}
