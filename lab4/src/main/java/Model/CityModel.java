package Model;

import Controller.city.CityImpl;
import org.json.simple.JSONArray;

public class CityModel {
    CityImpl controller = new CityImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow( String name, String region, int country) {
        controller.add(name, region, country);
    }

    public void updateRow(int id, String name, String region) {
        controller.updateById(id, name, region);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
