package iot.lviv.nikulshyn.flightradar24.controller.Current;

import iot.lviv.nikulshyn.flightradar24.model.Current;
import org.json.simple.JSONArray;

public interface CurrentImpl {
    public JSONArray read();
    public void create(Current entity);
    public void update(Current entity);
    public void delete(int id);
}
