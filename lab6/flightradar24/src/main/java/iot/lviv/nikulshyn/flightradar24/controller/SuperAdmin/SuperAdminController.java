package iot.lviv.nikulshyn.flightradar24.controller.SuperAdmin;

import iot.lviv.nikulshyn.flightradar24.model.Route;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.SuperAdmin;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SuperAdminController implements SuperAdminImpl {
    private Session session;

    public SuperAdminController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "SuperAdmin");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                SuperAdmin item = (SuperAdmin) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId());
                result.put("name", item.getName());
                result.put("pass", item.getPassword());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }

    @Override
    public void create(SuperAdmin entity) {
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
    public void update(SuperAdmin entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SuperAdmin item = session.get(SuperAdmin.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
