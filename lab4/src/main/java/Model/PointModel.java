package Model;

import Controller.point.PointImpl;
import org.json.simple.JSONArray;

public class PointModel {
    PointImpl controller = new PointImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow(String airport, int route, int city) {
        controller.add(airport, route, city);
    }

    public void updateRow(int id, String airport) {
        controller.updateById(id, airport);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
