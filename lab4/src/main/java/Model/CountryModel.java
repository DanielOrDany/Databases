package Model;

import Controller.country.CountryImpl;
import org.json.simple.JSONArray;

public class CountryModel {
    CountryImpl controller = new CountryImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow(String name, String language) {
        controller.add( name, language);
    }

    public void updateRow(int id, String name, String language) {
        controller.updateById(id, name, language);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
