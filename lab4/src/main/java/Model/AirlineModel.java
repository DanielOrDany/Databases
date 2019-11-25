package Model;

import Controller.airline.AirlineImpl;
import org.json.simple.JSONArray;

public class AirlineModel {
    AirlineImpl controller = new AirlineImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow( int partnership, String name, String registrationDate, String registrationCountry, int companyRevenue, int owner) {
        controller.add( partnership, name, registrationDate, registrationCountry, companyRevenue, owner);
    }

    public void updateRow(int id, int newPartnership, String newName, String newRegDate, String newRegCountry, int newComRevenue) {
        controller.updateById(id, newPartnership, newName, newRegDate, newRegCountry, newComRevenue);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}