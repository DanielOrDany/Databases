package iot.lviv.nikulshyn.flightradar24.controller.Owner;

import iot.lviv.nikulshyn.flightradar24.model.Owner;
import org.json.simple.JSONArray;

public interface OwnerImpl {
    public JSONArray read();
    public void create(Owner entity);
    public void update(Owner entity);
    public void delete(int id);
}
