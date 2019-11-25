package ua.lviv.iot.nikulshyn.controller.Route;

import ua.lviv.iot.nikulshyn.model.Route;

public interface RouteImpl {
    public void read();
    public void create(Route entity);
    public void update(Route entity);
    public void delete(int id);
}
