package iot.lviv.nikulshyn.flightradar24.controller.Airplane;

import iot.lviv.nikulshyn.flightradar24.model.Airline;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.Airplane;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AirplaneController implements AirplaneImpl{

    private Session session;

    public AirplaneController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Airplane");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Airplane item = (Airplane) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("name", item.getName());
                result.put("reg_date", item.getRegistrationDate());
                result.put("reg_country", item.getRegistrationCountry());
                result.put("serial_number", item.getSerialNumber());
                result.put("age", item.getAge());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(Airplane entity) {
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
    public void update(Airplane entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Airplane item = session.get(Airplane.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
