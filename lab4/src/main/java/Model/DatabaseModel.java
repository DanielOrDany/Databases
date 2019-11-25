package Model;

import Controller.database.DatabaseImpl;

public class DatabaseModel {
    DatabaseImpl controller = new DatabaseImpl();

    public void createOrUpdateDatabase(){
        controller.createDatabase();
    }
}
