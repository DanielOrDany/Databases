package ua.lviv.iot.nikulshyn.controller.Country;

import ua.lviv.iot.nikulshyn.model.Country;

public interface CountryImpl {
    public void read();
    public void create(Country entity);
    public void update(Country entity);
    public void delete(int id);
}
