package ua.lviv.iot.nikulshyn.controller.Current;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.Current;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class CurrentController implements CurrentImpl{
    private Session session;

    public CurrentController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Current");
            for (Object obj : query.list()) {
                Current item = (Current) obj;

                System.out.format(
                        item.getId().toString()         +"    "+
                        item.getWind().toString()       +"    "+
                        item.getTemperature().toString()                  +"    "+
                        item.getLatitude().toString()                +"    "+
                        item.getLongtitude().toString()                  +"    "+
                        item.getVerticalSpeed().toString()                +"    "+
                        item.getGpsAltitude().toString()                  +"    "+
                        item.getTrack().toString()                  +"    "+
                        item.getGroundSpeed().toString()                  +"    "+
                        item.getTrueSpeed().toString()                 +"    "+
                        item.getIndicatedSpeed().toString()                 +"    "+
                        item.getMarch().toString()                 +"    "+
                        item.getCalibratedAltitude().toString()                  +"    "+
                        item.getSquawk().toString()       +"    "+
                        item.getDateTime()      +"    "+
                        item.getAirplaneByAirplaneId()       +"\n"
                );

            }
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
