package iot.lviv.nikulshyn.flightradar24.controller.Point;

import iot.lviv.nikulshyn.flightradar24.model.Point;
import org.json.simple.JSONArray;

public interface PointImpl {
    public JSONArray read();
    public void create(Point entity);
    public void update(Point entity);
    public void delete(int id);
}
