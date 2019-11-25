package ua.lviv.iot.nikulshyn.controller.Airline;

import ua.lviv.iot.nikulshyn.model.Airline;

import java.util.List;

public interface AirlineImpl {
    public void read();
    public void create(Airline entity);
    public void update(Airline entity);
    public void delete(int id);
}
