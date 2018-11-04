package application.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Users extends DatabaseObject {
    private static final String FEILD_EMAIL = "EMAIL";
    private static final String FEILD_PASSWORD = "PASSWORD";
    private static final String FEILD_USERNAME = "USERNAME";

    /*
     *Find a cool way or representing a entry in this table
     */
    @Override
    public void buildTable() {
        /*
        *
         */
        updateTableName(this.getClass().getSimpleName());
        addVarcharFeild(FEILD_EMAIL, false);
        addVarcharFeild(FEILD_USERNAME, false);
        addVarcharFeild(FEILD_PASSWORD, true);//remove bool and add ending in build instead
        build();
    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

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
}
