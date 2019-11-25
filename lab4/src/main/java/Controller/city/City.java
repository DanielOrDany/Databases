package Controller.city;

import org.json.simple.JSONArray;

public interface City {
    void add (String new_name, String new_region, int new_country_id);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, String new_name, String new_region);
    void deleteById (int id);
}
