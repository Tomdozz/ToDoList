package application.database;

public class User {
	public int id;
	public String username;
	public String password;
	public String email;
	
	public User(String username, String password, String email) {
		this.email = email;
		this.password = password;
		this.username = username;
	}
}
