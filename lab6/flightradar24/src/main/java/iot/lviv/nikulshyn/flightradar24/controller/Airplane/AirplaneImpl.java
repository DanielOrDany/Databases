package iot.lviv.nikulshyn.flightradar24.controller.Airplane;

import iot.lviv.nikulshyn.flightradar24.model.Airplane;
import org.json.simple.JSONArray;

public interface AirplaneImpl {
    public JSONArray read();
    public void create(Airplane entity);
    public void update(Airplane entity);
    public void delete(int id);
}
