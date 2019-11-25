package iot.lviv.nikulshyn.flightradar24.controller.Password;

import iot.lviv.nikulshyn.flightradar24.model.Owner;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.SecretPassword;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PasswordController implements PasswordImpl {
    private Session session;

    public PasswordController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "SecretPassword");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                SecretPassword item = (SecretPassword) obj;

                JSONObject result = new JSONObject();
                result.put("password", item.getPassword());
                result.put("id_traveler", item.getTravelerId());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(SecretPassword entity) {
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
    public void update(SecretPassword entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SecretPassword item = session.get(SecretPassword.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
