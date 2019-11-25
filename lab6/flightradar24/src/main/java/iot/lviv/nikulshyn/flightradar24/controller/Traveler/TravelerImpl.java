package iot.lviv.nikulshyn.flightradar24.controller.Traveler;

import iot.lviv.nikulshyn.flightradar24.model.Traveler;
import org.json.simple.JSONArray;

public interface TravelerImpl {
    public JSONArray read();
    public void create(Traveler entity);
    public void update(Traveler entity);
    public void delete(int id);
}
