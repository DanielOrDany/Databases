package Controller.route;

import org.json.simple.JSONArray;

public interface Route {
    void add (String new_scheduled_from, String new_scheduled_to, int new_actual, int new_estimated, String new_departure_from, String new_arrival_to, int new_total_distance, int new_passed_distance, String new_date);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, String new_scheduled_from, String new_scheduled_to, int new_actual, int new_estimated, String new_departure_from, String new_arrival_to, int new_total_distance, int new_passed_distance, String new_date);
    void deleteById (int id);
}
