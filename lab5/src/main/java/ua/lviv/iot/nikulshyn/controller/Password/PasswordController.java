package ua.lviv.iot.nikulshyn.controller.Password;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.SecretPassword;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class PasswordController implements PasswordImpl {
    private Session session;

    public PasswordController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "SecretPassword");
            for (Object obj : query.list()) {
                SecretPassword item = (SecretPassword) obj;

                System.out.format(
                        item.getPassword()         +"    "+
                        item.getTravelerId()      +"\n"
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(SecretPassword entity) {
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
    public void update(SecretPassword entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SecretPassword item = session.get(SecretPassword.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
