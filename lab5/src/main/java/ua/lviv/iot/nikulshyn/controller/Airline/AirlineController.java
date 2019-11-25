package ua.lviv.iot.nikulshyn.controller.Airline;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.Airline;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;


public class AirlineController implements AirlineImpl{

    private Session session;

    public AirlineController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Airline");
            for (Object obj : query.list()) {
                Airline item = (Airline) obj;

                System.out.format(
                        item.getId().toString() +"    "+
                        item.getPartership().toString() +"    "+
                        item.getName() +"    "+
                        item.getRegistrationDate() +"    "+
                        item.getRegistrationCountry() +"    "+
                        item.getCompanyRevenue().toString() +"\n"
                );

            }
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
        Airline item = session.get(Airline.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
