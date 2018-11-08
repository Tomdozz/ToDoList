package application.database.databasecontent;

import application.database.DatabaseEntry;

public class User extends DatabaseEntry {

    public String username;
    public String password;
    public String email;

    public User(String username, String password, String email) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}