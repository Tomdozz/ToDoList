package application.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseEntry {
    public int id;
    String tableName;
    StringBuilder query = new StringBuilder("SELECT * FROM '" + tableName + "'");
    /*
   Querybuilder methods
    */
    public void init(){
        tableName = this.getClass().getSimpleName() + "s";
        query = new StringBuilder("SELECT * FROM '" + tableName + "'");
    }
    public StringBuilder and(String and) {
        return query.append("AND '" + and + "'");
    }
    public StringBuilder where(String where) {
        return query.append("WHERE '" + where + "'");
    }
    public StringBuilder like(String like){
        return query.append("LIKE '" + like + "'");
    }
    public StringBuilder equalsTo(String equalsTo){
        return query.append("=" + equalsTo + "'");
    }

    public StringBuilder getQuery() {
        return query;
    }
    public String getQueryString() {
        return query.toString();
    }


    public ResultSet executeQuery(){
        try(Connection connection = DBConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query.toString());
        ) {
            return result;
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}
