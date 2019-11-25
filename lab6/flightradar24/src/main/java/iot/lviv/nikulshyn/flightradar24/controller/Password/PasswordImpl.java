package iot.lviv.nikulshyn.flightradar24.controller.Password;

import iot.lviv.nikulshyn.flightradar24.model.SecretPassword;
import org.json.simple.JSONArray;

public interface PasswordImpl {
    public JSONArray read();
    public void create(SecretPassword entity);
    public void update(SecretPassword entity);
    public void delete(int id);
}
