package ua.lviv.iot.nikulshyn.controller.Owner;

import ua.lviv.iot.nikulshyn.model.Owner;

public interface OwnerImpl {
    public void read();
    public void create(Owner entity);
    public void update(Owner entity);
    public void delete(int id);
}
