package iot.lviv.nikulshyn.flightradar24.controller.SuperAdmin;

import iot.lviv.nikulshyn.flightradar24.model.SuperAdmin;
import org.json.simple.JSONArray;

public interface SuperAdminImpl {
    public JSONArray read();
    public void create(SuperAdmin entity);
    public void update(SuperAdmin entity);
    public void delete(int id);
}
