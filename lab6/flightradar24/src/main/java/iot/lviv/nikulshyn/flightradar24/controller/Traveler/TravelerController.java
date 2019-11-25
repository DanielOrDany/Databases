package iot.lviv.nikulshyn.flightradar24.controller.Traveler;

import iot.lviv.nikulshyn.flightradar24.model.SuperAdmin;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.Traveler;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TravelerController implements TravelerImpl{
    private Session session;

    public TravelerController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Traveler");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Traveler item = (Traveler) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId());
                result.put("name", item.getFullName());
                result.put("email", item.getEmail());
                result.put("lan", item.getLanguage());
                result.put("photo", item.getPhotoUrl());
                result.put("sub_end", item.getSubscriptionEnd());
                result.put("plan", item.getPlan());
                result.put("start_at", item.getStartAt());
                result.put("update_at", item.getUpdatedAt());
                result.put("delete_at", item.getDeletedAt());
                result.put("sub_start", item.getSubscriptionStart());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(Traveler entity) {
        session = SessionManager.getSession();
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            System.out.println(".saved");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Traveler entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Traveler item = session.get(Traveler.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
