package Controller.country;

import org.json.simple.JSONArray;

public interface Country {
    void add (String new_name, String new_language);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, String new_name, String new_language);
    void deleteById (int id);
}
