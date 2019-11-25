package iot.lviv.nikulshyn.flightradar24.controller.Airline;

import iot.lviv.nikulshyn.flightradar24.model.Airline;
import org.json.simple.JSONArray;
import org.springframework.context.annotation.Bean;

public interface AirlineImpl {
    public JSONArray read();
    public void create(Airline entity);
    public void update(Airline entity);
    public void delete(int id);
}
