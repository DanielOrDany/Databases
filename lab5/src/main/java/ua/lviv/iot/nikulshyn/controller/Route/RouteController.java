package ua.lviv.iot.nikulshyn.controller.Route;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.Route;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class RouteController implements RouteImpl{
    private Session session;

    public RouteController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Route");
            for (Object obj : query.list()) {
                Route item = (Route) obj;

                System.out.format(
                    item.getId()         +"    "+
                    item.getScheduledFrom()        +"    "+
                    item.getScheduledTo()      +"    "+
                    item.getActual()     +"    "+
                    item.getEstimated()      +"    "+
                    item.getDepartureFrom()      +"    "+
                    item.getArrivalTo()      +"    "+
                    item.getTotalDistance()      +"    "+
                    item.getPassedDistance()      +"    "+
                    item.getDate()     +"\n"
                );

            }
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
