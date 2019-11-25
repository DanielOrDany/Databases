package Controller.category;

import org.json.simple.JSONArray;

public interface Category {
    void add (String new_type);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, String type);
    void deleteById (int id);
}
