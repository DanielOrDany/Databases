package iot.lviv.nikulshyn.flightradar24.controller.Route;

import iot.lviv.nikulshyn.flightradar24.model.Route;
import org.json.simple.JSONArray;

public interface RouteImpl {
    public JSONArray read();
    public void create(Route entity);
    public void update(Route entity);
    public void delete(int id);
}
