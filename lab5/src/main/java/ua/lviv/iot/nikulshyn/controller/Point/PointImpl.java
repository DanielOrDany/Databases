package ua.lviv.iot.nikulshyn.controller.Point;

import ua.lviv.iot.nikulshyn.model.Point;

public interface PointImpl {
    public void read();
    public void create(Point entity);
    public void update(Point entity);
    public void delete(int id);
}
