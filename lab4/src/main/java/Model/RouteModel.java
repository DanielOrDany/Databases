package Model;

import Controller.route.RouteImpl;
import org.json.simple.JSONArray;

public class RouteModel {
    RouteImpl controller = new RouteImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow(String scheduledFrom, String scheduledTo, int actual, int estimated, String departureFrom, String arrivalTo, int totalDistance, int passedDistance, String date) {
        controller.add(scheduledFrom, scheduledTo, actual, estimated, departureFrom, arrivalTo, totalDistance, passedDistance, date);
    }

    public void updateRow(int id, String scheduledFrom, String scheduledTo, int actual, int estimated, String departureFrom, String arrivalTo, int totalDistance, int passedDistance, String date) {
        controller.updateById(id, scheduledFrom, scheduledTo, actual, estimated, departureFrom, arrivalTo, totalDistance, passedDistance, date);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
