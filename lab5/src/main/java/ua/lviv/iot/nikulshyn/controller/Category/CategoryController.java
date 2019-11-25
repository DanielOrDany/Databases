package ua.lviv.iot.nikulshyn.controller.Category;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.nikulshyn.model.AirplaneCategory;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;

public class CategoryController implements CategoryImpl{
    private Session session;

    public CategoryController(Session session){
        this.session = session;
    }

    @Override
    public void read() {
        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "AirplaneCategory ");
            for (Object obj : query.list()) {
                AirplaneCategory item = (AirplaneCategory) obj;

                System.out.format(
                        item.getId().toString()         +"    "+
                        item.getType()                  +"\n  "
                );

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void create(AirplaneCategory entity) {
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
    public void update(AirplaneCategory entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = SessionManager.getSession();
        AirplaneCategory item = session.get(AirplaneCategory.class, id);
        if (item != null) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        }
    }
}
