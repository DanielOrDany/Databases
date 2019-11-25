package ua.lviv.iot.nikulshyn.controller.City;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.City;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class CityController implements CityImpl{
    private Session session;

    public CityController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "City");
            for (Object obj : query.list()) {
                City item = (City) obj;

                System.out.format(
                        item.getId().toString()         +"    "+
                        item.getName()                  +"    "+
                        item.getRegion()                +"    "+
                        item.getCountryByCountryId()    +"\n  "
                );

            }
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
