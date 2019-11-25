package Controller.current;

import org.json.simple.JSONArray;

public interface Current {
    void add (int new_wind, int new_temperature, float new_latitude, float new_longtitude, int new_vertical_speed, int new_gps_altitude, int new_track, int new_ground_speed, int new_true_speed, int new_indicated_speed, int new_march, int new_calibrated_altitude, int new_icao, int new_squawk, int new_date_time, int new_airplane_id);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, int new_wind, int new_temperature, float new_latitude, float new_longtitude, int new_vertical_speed, int new_gps_altitude, int new_track, int new_ground_speed, int new_true_speed, int new_indicated_speed, int new_march, int new_calibrated_altitude, int new_icao, int new_squawk, int new_date_time);
    void deleteById (int id);
}
