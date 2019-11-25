package Controller.airplane;

import org.json.simple.JSONArray;

public interface Airplane {
    void add (String new_name, String new_registration_date, String new_registration_country, String new_serial_number, int new_age, int new_airplane_category_id, int new_airline_id, int route_id);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, String new_name, String new_registration_date, String new_registration_country, String new_serial_number, int new_age);
    void deleteById (int id);
}
