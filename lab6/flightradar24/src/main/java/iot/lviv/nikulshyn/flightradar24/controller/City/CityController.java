package iot.lviv.nikulshyn.flightradar24.controller.City;

import iot.lviv.nikulshyn.flightradar24.model.AirplaneCategory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.City;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CityController implements CityImpl{
    private Session session;

    public CityController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "City");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                City item = (City) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("name", item.getName());
                result.put("region", item.getRegion());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(City entity) {
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
    public void update(City entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        City item = session.get(City.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
