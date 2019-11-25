package ua.lviv.iot.nikulshyn.controller.Airplane;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.Airline;
import ua.lviv.iot.nikulshyn.model.Airplane;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class AirplaneController implements AirplaneImpl{

    private Session session;

    public AirplaneController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Airplane");
            for (Object obj : query.list()) {
                Airplane item = (Airplane) obj;

                System.out.format(
                        item.getId().toString()         +"    "+
                        item.getName()                  +"    "+
                        item.getRegistrationDate()      +"    "+
                        item.getRegistrationCountry()   +"    "+
                        item.getSerialNumber()          +"    "+
                        item.getAge()                   +"    "+
                        item.getAirplaneCategoryByAirplaneCategoryId()          +"    "+
                        item.getAirlineByAirlineId()    +"    "+
                        item.getRouteByRouteId()        +"    "+
                        item.getAge()                   +"\n  "
                );

            }
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
