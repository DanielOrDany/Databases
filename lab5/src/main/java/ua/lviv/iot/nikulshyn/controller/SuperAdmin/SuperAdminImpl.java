package ua.lviv.iot.nikulshyn.controller.SuperAdmin;

import ua.lviv.iot.nikulshyn.model.SuperAdmin;

public interface SuperAdminImpl {
    public void read();
    public void create(SuperAdmin entity);
    public void update(SuperAdmin entity);
    public void delete(int id);
}
