package ua.lviv.iot.nikulshyn.controller.Current;

import ua.lviv.iot.nikulshyn.model.Current;

public interface CurrentImpl {
    public void read();
    public void create(Current entity);
    public void update(Current entity);
    public void delete(int id);
}
