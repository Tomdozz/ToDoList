package application.database;

import java.util.ArrayList;

public class DatabaseController {
    ArrayList<DatabaseObject> dbObjects = new ArrayList<>();

    public void run(){
        registerDbObjects();
        buildDatabses();
    }
    private void buildDatabses() {
        for (DatabaseObject d: dbObjects) {
            d.buildTable();
        }
    }
    private void registerDbObjects(){
        /*
        *Register all db objects here
         */
        Users u = new Users();
        dbObjects.add(u);
    }
}
