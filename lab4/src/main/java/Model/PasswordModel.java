package Model;

import Controller.password.PasswordImpl;
import org.json.simple.JSONArray;

public class PasswordModel {
    PasswordImpl controller = new PasswordImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow(String password, int traveler) {
        controller.add(password, traveler);
    }

    public void updateRow(int id, String password) {
        controller.updateById(id, password);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
