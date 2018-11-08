package application.database;

import java.util.ArrayList;

public class DatabaseController {
    ArrayList<DatabaseObject> dbObjects = new ArrayList<>();
    ArrayList<DatabaseEntry> dbEntries = new ArrayList<>();

    public void run(){
        registerDbObjects();
        registerEntries();
        buildDatabses();
        initEntries();
    }
    private void buildDatabses() {
        for (DatabaseObject d: dbObjects) {
            d.buildTable();
        }
    }
    private void initEntries(){
        for (DatabaseEntry d: dbEntries) {
            d.init();
        }
    }
    private void registerDbObjects(){
        /*
        *Register all db objects here
         */
        Users u = new Users();
        dbObjects.add(u);
    }
    private void registerEntries(){
        /*
         *Register all db entries here
         */
        User u = new User(null,null, null);
        dbEntries.add(u);
    }
}
