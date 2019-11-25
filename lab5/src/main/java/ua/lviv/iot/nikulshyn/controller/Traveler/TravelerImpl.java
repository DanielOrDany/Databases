package ua.lviv.iot.nikulshyn.controller.Traveler;

import ua.lviv.iot.nikulshyn.model.Traveler;

public interface TravelerImpl {
    public void read();
    public void create(Traveler entity);
    public void update(Traveler entity);
    public void delete(int id);
}
