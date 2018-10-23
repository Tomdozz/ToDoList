package application.database;
import java.sql.*;

public class JDBCConnection {
	public static void main(String[] args) {
		connect();
	}
	public static void connect() {
		String query = "SELECT * FROM `members` WHERE `username` LIKE 'tomdozz'";
		//try with resources
		//all variables initated within the try parameter will be automatically closed
		try (Connection connection = DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet result = stmt.executeQuery(query);)
		{
			System.out.println("connected to DB");
			while (result.next()) {
				System.out.println("name" + result.getString("username"));			
			}
			
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
}
