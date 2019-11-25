package ua.lviv.iot.nikulshyn.controller.Category;

import ua.lviv.iot.nikulshyn.model.AirplaneCategory;

public interface CategoryImpl {
    public void read();
    public void create(AirplaneCategory entity);
    public void update(AirplaneCategory entity);
    public void delete(int id);
}
