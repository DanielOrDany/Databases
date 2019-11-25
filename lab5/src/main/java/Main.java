import org.hibernate.Session;
import ua.lviv.iot.nikulshyn.persistant.SessionManager;
import ua.lviv.iot.nikulshyn.view.MainView;

public class Main {

    public static void main(final String[] args) {
        try (Session session = SessionManager.getSession()) {
            new MainView(session).show();
        }
    }
}