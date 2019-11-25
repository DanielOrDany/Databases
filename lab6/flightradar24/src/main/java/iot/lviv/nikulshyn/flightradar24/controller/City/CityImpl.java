package iot.lviv.nikulshyn.flightradar24.controller.City;

import iot.lviv.nikulshyn.flightradar24.model.City;
import org.json.simple.JSONArray;

public interface CityImpl {
    public JSONArray read();
    public void create(City entity);
    public void update(City entity);
    public void delete(int id);
}
