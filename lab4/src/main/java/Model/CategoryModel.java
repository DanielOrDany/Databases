package Model;

import Controller.category.CategoryImpl;
import org.json.simple.JSONArray;

public class CategoryModel {
    CategoryImpl controller = new CategoryImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow(String type) {
        controller.add( type);
    }

    public void updateRow(int id, String type) {
        controller.updateById(id, type);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
