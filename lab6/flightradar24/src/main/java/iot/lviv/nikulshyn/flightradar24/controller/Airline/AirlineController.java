package iot.lviv.nikulshyn.flightradar24.controller.Airline;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.Airline;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;

public class AirlineController implements AirlineImpl{

    private Session session;

    public AirlineController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Airline");
            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Airline item = (Airline) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("partnership", item.getPartership().toString());
                result.put("name", item.getName());
                result.put("reg_date", item.getRegistrationDate());
                result.put("reg_country", item.getRegistrationCountry());
                result.put("revenue", item.getCompanyRevenue().toString());
                full_result.add(result);
            }

            return full_result;
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Airline entity) {
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
    public void update(Airline entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        System.out.println(id);
        Airline item = session.get(Airline.class, id);
        System.out.println("session is openned");
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
