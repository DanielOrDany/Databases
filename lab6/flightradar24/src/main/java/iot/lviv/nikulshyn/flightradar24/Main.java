package iot.lviv.nikulshyn.flightradar24;

import org.hibernate.Session;
import iot.lviv.nikulshyn.flightradar24.persistant.SessionManager;
import iot.lviv.nikulshyn.flightradar24.view.MainView;

public class Main {

    public static void main(final String[] args) {
        try (Session session = SessionManager.getSession()) {
            new MainView(session).show();
        }
    }
}