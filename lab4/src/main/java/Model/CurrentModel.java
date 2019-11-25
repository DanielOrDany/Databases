package Model;

import Controller.current.CurrentImpl;
import org.json.simple.JSONArray;

public class CurrentModel {
    CurrentImpl controller = new CurrentImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow(int wind, int temperature, float latitude, float longtitude, int verticalSpeed, int gpsAltitude, int track, int groundSpeed, int trueSpeed, int indicatedSpeed, int march, int calibratedAltitude, int icao, int squawk, int dateTime, int airplane) {
        controller.add(wind, temperature, latitude, longtitude, verticalSpeed, gpsAltitude, track, groundSpeed, trueSpeed, indicatedSpeed, march, calibratedAltitude, icao, squawk, dateTime, airplane);
    }

    public void updateRow(int id, int wind, int temperature, float latitude, float longtitude, int verticalSpeed, int gpsAltitude, int track, int groundSpeed, int trueSpeed, int indicatedSpeed, int march, int calibratedAltitude, int icao, int squawk, int dateTime) {
        controller.updateById(id, wind, temperature, latitude, longtitude, verticalSpeed, gpsAltitude, track, groundSpeed, trueSpeed, indicatedSpeed, march, calibratedAltitude, icao, squawk, dateTime);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
