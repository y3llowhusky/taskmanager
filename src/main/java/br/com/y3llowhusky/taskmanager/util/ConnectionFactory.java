package br.com.y3llowhusky.taskmanager.util;

import java.util.Properties;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory {
	
	public static Connection getConnection() {	
		
		Connection con = null;
		
		try {
			
			Properties props = new Properties();
			InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties");
			
			props.load(input);
			
			String url = props.getProperty("db.url");
			String user = props.getProperty("db.user");
			String password = props.getProperty("db.password");
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
