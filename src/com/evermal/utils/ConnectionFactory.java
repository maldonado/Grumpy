package com.evermal.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static final String PROPERTIES_FILE = "grumpy.properties";
	
	private static String driverName;
	private static String dbURL;
	private static String username;
	private static String password;
	private static Properties properties = setupProperties();
	
	public static Connection getConnection(){
        try {
			Class.forName(driverName);
			return DriverManager.getConnection(dbURL, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}

	private static Properties setupProperties() {
		try {
			Properties props = new Properties(System.getProperties());
	        props.load(new FileInputStream(PROPERTIES_FILE));
	        driverName = props.getProperty("database.driverName");
	        dbURL = props.getProperty("database.dburl");
	        username = props.getProperty("database.dbuser");
	        password = props.getProperty("database.dbpw");
			return properties;	
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}	
}