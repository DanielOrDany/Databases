package Model;

import Controller.traveler.TravelerImpl;
import org.json.simple.JSONArray;

public class TravelerModel {
    TravelerImpl controller = new TravelerImpl();

    public JSONArray getTable() {
        return controller.getAll();
    }

    public JSONArray getRow(int id) {
        return controller.getById(id);
    }

    public void addRow(String fullName, String email, String language, String photoUrl, String subscriptionEnd, String plan, String startAt, String updateAt, String deletedAt, String subscriptionStart, int airplane, int airline) {
        controller.add(fullName, email, language, photoUrl, subscriptionEnd, plan, startAt, updateAt, deletedAt, subscriptionStart, airplane, airline);
    }

    public void updateRow(int id, String fullName, String email, String language, String photoUrl, String subscriptionEnd, String plan, String startAt, String updateAt, String deletedAt, String subscriptionStart) {
        controller.updateById(id, fullName, email, language, photoUrl, subscriptionEnd, plan, startAt, updateAt, deletedAt, subscriptionStart);
    }

    public void deleteRow(int id){
        controller.deleteById(id);
    }
}
