package com.hand.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String durl;
	private static String user;
	private static String password;

	private static final ConnectionFactory FACTORY = new ConnectionFactory();

	private Connection conn;

	// 单例
	private ConnectionFactory() {

	}

	static {
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
			System.out.println();
		} catch (Exception e) {
			System.out.println("=====读取配置文件错误====");
		}

		driver = prop.getProperty("driver");
		durl = prop.getProperty("durl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		
	}

	public static ConnectionFactory getInstance() {
		return FACTORY;

	}

	public Connection makeConnextion(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(durl,user,password);
			System.out.println(driver);
			System.out.println(durl);
			System.out.println(user);
		} catch (Exception e) {
		}
		return conn;
	
	}
}