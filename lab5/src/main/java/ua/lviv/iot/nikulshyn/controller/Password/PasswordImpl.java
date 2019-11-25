package ua.lviv.iot.nikulshyn.controller.Password;

import ua.lviv.iot.nikulshyn.model.SecretPassword;

public interface PasswordImpl {
    public void read();
    public void create(SecretPassword entity);
    public void update(SecretPassword entity);
    public void delete(int id);
}
