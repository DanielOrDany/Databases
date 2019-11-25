package iot.lviv.nikulshyn.flightradar24.controller.Owner;

import iot.lviv.nikulshyn.flightradar24.model.Current;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.Owner;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class OwnerController implements OwnerImpl{
    private Session session;

    public OwnerController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Owner");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Owner item = (Owner) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("full_name", item.getFullName());
                result.put("age", item.getAge());
                result.put("adress", item.getLiveAdress());
                result.put("email", item.getEmail());
                result.put("phone", item.getPhone());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(Owner entity) {
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
    public void update(Owner entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Owner item = session.get(Owner.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
