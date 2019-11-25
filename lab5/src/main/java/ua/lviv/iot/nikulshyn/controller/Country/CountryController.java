package ua.lviv.iot.nikulshyn.controller.Country;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.Country;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class CountryController implements CountryImpl{
    private Session session;

    public CountryController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Country ");
            for (Object obj : query.list()) {
                Country item = (Country) obj;

                System.out.format(
                        item.getId().toString()         +"    "+
                        item.getName()                  +"    "+
                        item.getLanguage()              +"\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Country entity) {
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
    public void update(Country entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Country item = session.get(Country.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
