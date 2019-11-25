package Controller.owner;

import org.json.simple.JSONArray;

public interface Owner {
    void add (String new_full_name, int new_age, String new_live_adress, String new_email, String new_phone, int new_country_id, int new_city_id);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, String new_full_name, int new_age, String new_live_adress, String new_email, String new_phone, int new_country_id, int new_city_id);
    void deleteById (int id);
}
