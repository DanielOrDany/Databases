package Controller.point;

import org.json.simple.JSONArray;

public interface Point {
    void add ( String new_airport, int new_route_id, int new_city_id);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, String new_airport);
    void deleteById (int id);
}
