package ua.lviv.iot.nikulshyn.controller.Airplane;

import ua.lviv.iot.nikulshyn.model.Airplane;

public interface AirplaneImpl {
    public void read();
    public void create(Airplane entity);
    public void update(Airplane entity);
    public void delete(int id);
}
