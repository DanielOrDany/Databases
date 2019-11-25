package ua.lviv.iot.nikulshyn.controller.SuperAdmin;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.SuperAdmin;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class SuperAdminController implements SuperAdminImpl {
    private Session session;

    public SuperAdminController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "SuperAdmin");
            for (Object obj : query.list()) {
                SuperAdmin item = (SuperAdmin) obj;

                System.out.format(
                        item.getId().toString()         +"    "+
                                item.getName()          +"    "+
                                item.getPassword()      +"\n  "
                );

            }
        } finally {
            session.close();
        }
    }

    @Override
    public void create(SuperAdmin entity) {
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
    public void update(SuperAdmin entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SuperAdmin item = session.get(SuperAdmin.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
