package iot.lviv.nikulshyn.flightradar24.controller.Current;

import iot.lviv.nikulshyn.flightradar24.model.Country;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.Current;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CurrentController implements CurrentImpl{
    private Session session;

    public CurrentController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Current");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Current item = (Current) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId().toString());
                result.put("wind", item.getWind().toString());
                result.put("temp", item.getTemperature().toString());
                result.put("latitude", item.getLatitude().toString());
                result.put("longtitude", item.getLongtitude().toString());
                result.put("v_speed", item.getVerticalSpeed().toString());
                result.put("gps", item.getGpsAltitude().toString());
                result.put("track", item.getTrack().toString());
                result.put("g_speed", item.getGroundSpeed().toString());
                result.put("t_speed", item.getTrueSpeed().toString());
                result.put("i_speed", item.getIndicatedSpeed().toString());
                result.put("march", item.getMarch().toString());
                result.put("calibrated_altitude", item.getCalibratedAltitude().toString());
                result.put("squawk", item.getSquawk().toString());
                result.put("time", item.getDateTime() );
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(Current entity) {
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
    public void update(Current entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Current item = session.get(Current.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
