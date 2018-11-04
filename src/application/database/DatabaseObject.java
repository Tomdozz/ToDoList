package application.database;

import java.sql.*;

import static application.database.StaticVariables.DB_NAME;

public abstract class DatabaseObject {
    String tableName;
    String query = "SELECT * FROM '" + tableName + "'";
    StringBuilder tableBuild = new StringBuilder("CREATE TABLE `" + DB_NAME + "`.`" + tableName + "`( `ID` INT NOT NULL AUTO_INCREMENT");

    public String getQuery() {
        return query;
    }

    public void updateTableName(String tableName) {
        this.tableName = tableName;
        tableBuild = new StringBuilder("CREATE TABLE `" + DB_NAME + "`.`" + tableName + "`( `ID` INT NOT NULL AUTO_INCREMENT");
        query = "SELECT * FROM '" + tableName + "'";
    }

    void addVarcharFeild(String feildName, boolean lastFeild) {
            tableBuild.append(",`" + feildName + "`VARCHAR(255) NOT NULL");
    }

    void addIntFeild(String feildName, boolean lastFeild) {
            tableBuild.append(",`" + feildName + "`INT NOT NULL");
    }

    void build() {
        if (!exists()) {
            tableBuild.append(",PRIMARY KEY (`ID`));");
            try (Connection connection = DBConnection.getConnection();
                 Statement stmt = connection.createStatement();) {
                System.out.println(tableBuild.toString());
                stmt.executeUpdate(tableBuild.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    boolean exists() {
        try (Connection connection = DBConnection.getConnection();
        ) {
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet result = dbm.getTables(DB_NAME, null, tableName, null);
            if (result.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public abstract void buildTable();
    public abstract void add();
    public abstract void remove();
}
