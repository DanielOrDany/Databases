package Model;

import Controller.airplane.AirplaneImpl;
import org.json.simple.JSONArray;

public class AirplaneModel {
    AirplaneImpl controller = new AirplaneImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow(String name, String registrationDate, String registrationСountry, String serialNumber, int age, int airplaneCategory, int airline, int route) {
        controller.add( name, registrationDate, registrationСountry, serialNumber, age, airplaneCategory, airline, route);
    }

    public void updateRow(int id, String name, String registrationDate, String registrationCountry, String serialNumber, int age) {
        controller.updateById(id, name, registrationDate, registrationCountry, serialNumber, age);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
