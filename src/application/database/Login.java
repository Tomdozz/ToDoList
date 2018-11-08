package application.database;

import application.database.databasecontent.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class  Login {

	public static User getUser(String username, String password) {
		String query = "SELECT * FROM `members` WHERE `username` = '" + username + "' AND `password` = '" + password
				+ "'";
		// "SELECT * FROM `members` WHERE `username` LIKE '"+ username + "'";
		User usr = new User(null, null, null);
		// try with resources
		// all variables initated within the try parameter 
		//will be automatically closed
		try (Connection connection = DBConnection.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet result = stmt.executeQuery(query);) {
			System.out.println("connected to DB");
			while (result.next()) {
				usr.id = result.getInt("id");
				usr.username = result.getString("username");
				usr.password = result.getString("password");
				usr.email = result.getString("email");
			}

		} catch (SQLException e) {
			System.err.println(e);
		}

		return usr;
	}
	
	public static User getUser(String email) {
		String query = "SELECT * FROM `members` WHERE `email` LIKE '"+ email +"'";
		User usr = new User(null, null, null);
		try (Connection connection = DBConnection.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet result = stmt.executeQuery(query);) {
			while (result.next()) {
				usr.id = result.getInt("id");
				usr.username = result.getString("username");
				usr.password = result.getString("password");
				usr.email = result.getString("email");
			}

		} catch (SQLException e) {
			System.err.println(e);
		}

		return usr;
	}

	public static User addUser(User user) {
		//String query = "SELECT * FROM `members` WHERE `username` = '" + username + "' AND `password` = '" + password
		String query = "INSERT INTO `members` (`id`, `username`, `password`, `email`) VALUES (NULL, '"+ user.username +"', '"+ user.password +"', '"+ user.email +"')";
				
		try (Connection connection = DBConnection.getConnection();
				Statement stmt = connection.createStatement();
				) {
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			System.err.println(e);
		}
		return null;
	}
}
