package Controller.password;

import org.json.simple.JSONArray;

public interface Password {
    void add (String password, int traveler_id);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int id, String password);
    void deleteById (int id);
}
