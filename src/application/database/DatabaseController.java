package application.database;

import application.database.databasecontent.User;
import application.database.databasecontent.Users;

import java.sql.*;
import java.util.ArrayList;

import static application.database.StaticVariables.DB_CONN;
import static application.database.StaticVariables.DB_NAME;

public class DatabaseController {
    ArrayList<DatabaseObject> dbObjects = new ArrayList<>();
    ArrayList<DatabaseEntry> dbEntries = new ArrayList<>();
    String query ="CREATE DATABASE " +DB_NAME;

    //https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
    public void run() {
        createDBIfNotExsist();
        registerDbObjects();
        registerEntries();
        buildDatabses();
        initEntries();
    }

    private void buildDatabses() {
        for (DatabaseObject d : dbObjects) {
            d.buildTable();
        }
    }

    private void initEntries() {
        for (DatabaseEntry d : dbEntries) {
            d.init();
        }
    }

    private void registerDbObjects() {
        /*
         *Register all db objects here
         */
        Users u = new Users();
        dbObjects.add(u);
    }

    private void registerEntries() {
        /*
         *Register all db entries here
         */
        User u = new User(null, null, null);
        dbEntries.add(u);
    }

    private void createDBIfNotExsist() {
        if (!exists()) {
            try (Connection connection = DBConnection.getConnection();
                 Statement stmt = connection.createStatement();) {
                stmt.executeUpdate(query);
                DB_CONN.append(DB_NAME);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    boolean exists() {
        try (Connection connection = DBConnection.getConnection();
        ) {
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet result = dbm.getCatalogs();
            while (result.next()) {
                String catalogs = result.getString(1);
                if (DB_NAME.equals(catalogs)) {
                    return true;
                }
            }
            DB_CONN.append(DB_NAME);
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
