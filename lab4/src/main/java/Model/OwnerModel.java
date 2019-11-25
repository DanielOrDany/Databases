package Model;

import Controller.owner.OwnerImpl;
import org.json.simple.JSONArray;

public class OwnerModel {
    OwnerImpl controller = new OwnerImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow(String fullName, int age, String liveAdress, String email, String phone, int country, int city) {
        controller.add(fullName, age, liveAdress, email, phone, country, city);
    }

    public void updateRow(int id, String fullName, int age, String liveAdress, String email, String phone, int country, int city) {
        controller.updateById(id, fullName, age, liveAdress, email, phone, country, city);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
