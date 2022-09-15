package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTools implements AutoCloseable{
	private String driverStr;
	private String url;
	private String acc;
	private String pwd;
	
	private Connection con;
	
	public static final DBTools DBTOOLS = new DBTools();
	
	private DBTools() {
		
	}
	
	void initDBTools(String driverStr, String url, String acc, String pwd) {
		this.driverStr = driverStr;
		this.url = url;
		this.acc = acc;
		this.pwd = pwd;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driverStr);
			con = DriverManager.getConnection(url, acc, pwd);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}
		
		return con;
	}


	@Override
	public void close() throws Exception {
		con.close();
	}
}
