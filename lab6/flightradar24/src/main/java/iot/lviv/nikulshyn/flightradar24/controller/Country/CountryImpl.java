package iot.lviv.nikulshyn.flightradar24.controller.Country;

import iot.lviv.nikulshyn.flightradar24.model.Country;
import org.json.simple.JSONArray;

public interface CountryImpl {
    public JSONArray read();
    public void create(Country entity);
    public void update(Country entity);
    public void delete(int id);
}
