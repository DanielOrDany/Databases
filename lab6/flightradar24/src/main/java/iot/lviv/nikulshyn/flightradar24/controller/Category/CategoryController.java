package iot.lviv.nikulshyn.flightradar24.controller.Category;

import iot.lviv.nikulshyn.flightradar24.model.Airplane;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.AirplaneCategory;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CategoryController implements CategoryImpl{
    private Session session;

    public CategoryController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "AirplaneCategory ");
            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                AirplaneCategory item = (AirplaneCategory) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("type", item.getType());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(AirplaneCategory entity) {
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
    public void update(AirplaneCategory entity) {
        session = SessionManager.getSession();
        try {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            System.out.println(".updated");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        AirplaneCategory item = session.get(AirplaneCategory.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
