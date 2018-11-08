package application.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Users extends DatabaseObject {
    private static final String FEILD_EMAIL = "EMAIL";
    private static final String FEILD_PASSWORD = "PASSWORD";
    private static final String FEILD_USERNAME = "USERNAME";

    @Override
    public void buildTable() {
        /*
         *Has to be done in these steps(databaseObject class will handle the rest)
         * 1.update name
         * 2.add feilds
         * 3.build
         */
        updateTableName(this.getClass().getSimpleName());
        addVarcharFeild(FEILD_EMAIL);
        addVarcharFeild(FEILD_USERNAME);
        addVarcharFeild(FEILD_PASSWORD);//remove bool and add ending in build instead
        build();
    }

    @Override
    public void setObject(DatabaseEntry user) {

    }

    @Override
    public void remove(DatabaseEntry user) {

    }

    @Override
    public DatabaseEntry getObject() {
        return null;
    }
}
