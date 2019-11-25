package ua.lviv.iot.nikulshyn.controller.Owner;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.Owner;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class OwnerController implements OwnerImpl{
    private Session session;

    public OwnerController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Owner");
            for (Object obj : query.list()) {
                Owner item = (Owner) obj;

                System.out.format(
                        item.getId().toString()         +"    "+
                        item.getFullName()       +"    "+
                        item.getAge()                  +"    "+
                        item.getLiveAdress()                +"    "+
                        item.getEmail()                  +"    "+
                        item.getPhone()                +"    "+
                        item.getCountryByCountryId() +"     "+
                        item.getCityByCityId()               +"\n"
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(Owner entity) {
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
    public void update(Owner entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Owner item = session.get(Owner.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
