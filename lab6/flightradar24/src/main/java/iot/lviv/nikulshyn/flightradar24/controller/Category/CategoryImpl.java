package iot.lviv.nikulshyn.flightradar24.controller.Category;

import iot.lviv.nikulshyn.flightradar24.model.AirplaneCategory;
import org.json.simple.JSONArray;

public interface CategoryImpl {
    public JSONArray read();
    public void create(AirplaneCategory entity);
    public void update(AirplaneCategory entity);
    public void delete(int id);
}
