package Controller.traveler;

import org.json.simple.JSONArray;

public interface Traveler {
    void add (String new_full_name, String new_email, String new_language, String new_photo_url, String new_subscription_end, String new_plan, String new_start_at, String new_update_at, String deleted_at, String new_subscription_start, int new_airplane_id, int new_airline_id);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, String new_full_name, String new_email, String new_language, String new_photo_url, String new_subscription_end, String new_plan, String new_start_at, String new_update_at, String new_deleted_at, String new_subscription_start);
    void deleteById (int id);
}
