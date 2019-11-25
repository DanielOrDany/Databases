package ua.lviv.iot.nikulshyn.controller.Point;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.Point;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class PointController implements PointImpl{
    private Session session;

    public PointController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Point");
            for (Object obj : query.list()) {
                Point item = (Point) obj;

                System.out.format(
                        item.getId()         +"    "+
                        item.getAirport()        +"    "+
                        item.getRouteByRouteId()       +"    "+
                        item.getCityByCityId()         +"\n"
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Point entity) {
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
    public void update(Point entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Point item = session.get(Point.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
