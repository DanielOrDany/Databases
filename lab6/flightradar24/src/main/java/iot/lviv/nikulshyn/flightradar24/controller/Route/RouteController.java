package iot.lviv.nikulshyn.flightradar24.controller.Route;

import iot.lviv.nikulshyn.flightradar24.model.Point;
import org.hibernate.Session;
import org.hibernate.query.Query;
import iot.lviv.nikulshyn.flightradar24.model.Route;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RouteController implements RouteImpl{
    private Session session;

    public RouteController(Session session){
        this.session = session;
    }

    @Override
    public JSONArray read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Route");

            JSONArray full_result = new JSONArray();

            for (Object obj : query.list()) {
                Route item = (Route) obj;

                JSONObject result = new JSONObject();
                result.put("id", item.getId());
                result.put("s_from", item.getScheduledFrom());
                result.put("s_to", item.getScheduledTo());
                result.put("actual", item.getActual());
                result.put("estimated", item.getEstimated());
                result.put("d_from", item.getDepartureFrom());
                result.put("a_to", item.getArrivalTo());
                result.put("total", item.getTotalDistance());
                result.put("passed", item.getPassedDistance());
                result.put("date", item.getDate());
                full_result.add(result);
            }
            return full_result;

        } finally {
            session.close();
        }
    }


    @Override
    public void create(Route entity) {
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
    public void update(Route entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Route item = session.get(Route.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
