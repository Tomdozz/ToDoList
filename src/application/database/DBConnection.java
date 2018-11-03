package application.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static application.database.StaticVariables.*;

//static connection to use always
public class DBConnection {

	private static final String USERNAME = DB_USR;
	private static final String PASSWORD = DB_PASS;
	private static final String DBCONN = DB_CONN;
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(DBCONN, USERNAME, PASSWORD);
	}
	
}
