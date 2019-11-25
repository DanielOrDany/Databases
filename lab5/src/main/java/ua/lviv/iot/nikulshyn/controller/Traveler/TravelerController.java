package ua.lviv.iot.nikulshyn.controller.Traveler;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.Route;
import ua.lviv.iot.nikulshyn.model.Traveler;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class TravelerController implements TravelerImpl{
    private Session session;

    public TravelerController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Traveler");
            for (Object obj : query.list()) {
                Traveler item = (Traveler) obj;

                System.out.format(
                    item.getId()         +"    "+
                    item.getFullName()        +"    "+
                    item.getEmail()     +"    "+
                    item.getLanguage()    +"    "+
                    item.getPhotoUrl()      +"    "+
                    item.getSubscriptionEnd()      +"    "+
                    item.getPlan()      +"    "+
                    item.getStartAt()     +"    "+
                    item.getUpdatedAt()      +"    "+
                    item.getDeletedAt()     +"    "+
                    item.getSubscriptionStart()      +"    "+
                    item.getAirplaneByAirplaneId()      +"    "+
                    item.getAirlineByAirlineId()     +"\n"
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Traveler entity) {
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
    public void update(Traveler entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Traveler item = session.get(Traveler.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
