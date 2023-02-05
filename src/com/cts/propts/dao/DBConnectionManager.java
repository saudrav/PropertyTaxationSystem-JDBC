package com.cts.propts.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cts.propts.exception.PropertyTaxPytException;

public class DBConnectionManager {

	 
	private static Connection con = null;
	private static DBConnectionManager instance;
	private static Properties props = new Properties();
	
	public  DBConnectionManager()  throws PropertyTaxPytException
	{		
		// TYPE YOUR  CODE HERE		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("database.properties");
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		// load the Driver Class
		try {
			Class.forName(props.getProperty("drivername"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static DBConnectionManager getInstance() throws PropertyTaxPytException {
		
		// TYPE YOUR  CODE HERE 
		if (instance == null) {
	        instance = new DBConnectionManager();
	    }
		return instance;
	}
	
	public Connection getConnection() {
		
		    // create the connection now
			try {
				con = DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
	}
	
}
