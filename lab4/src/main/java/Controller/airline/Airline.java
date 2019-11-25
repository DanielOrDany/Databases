package Controller.airline;

import org.json.simple.JSONArray;

public interface Airline {
    void add (int new_partership, String new_name, String new_registration_date, String new_registration_country, int new_company_revenue, int new_owner_id);
    JSONArray getAll ();
    JSONArray getById (int id);
    void updateById (int paramId, int newPartnership, String newName, String newRegDate, String newRegCountry, int newComRevenue);
    void deleteById (int id);
}
