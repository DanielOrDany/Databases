package ua.lviv.iot.nikulshyn.controller.City;

import ua.lviv.iot.nikulshyn.model.City;

public interface CityImpl {
    public void read();
    public void create(City entity);
    public void update(City entity);
    public void delete(int id);
}
