package iot.lviv.nikulshyn.flightradar24.view;

import org.hibernate.Session;
import iot.lviv.nikulshyn.flightradar24.controller.Airline.AirlineController;
import iot.lviv.nikulshyn.flightradar24.controller.Airplane.AirplaneController;
import iot.lviv.nikulshyn.flightradar24.controller.Category.CategoryController;
import iot.lviv.nikulshyn.flightradar24.controller.City.CityController;
import iot.lviv.nikulshyn.flightradar24.controller.Country.CountryController;
import iot.lviv.nikulshyn.flightradar24.controller.Current.CurrentController;
import iot.lviv.nikulshyn.flightradar24.controller.Owner.OwnerController;
import iot.lviv.nikulshyn.flightradar24.controller.Password.PasswordController;
import iot.lviv.nikulshyn.flightradar24.controller.Point.PointController;
import iot.lviv.nikulshyn.flightradar24.controller.Route.RouteController;
import iot.lviv.nikulshyn.flightradar24.controller.SuperAdmin.SuperAdminController;
import iot.lviv.nikulshyn.flightradar24.controller.Traveler.TravelerController;

import java.util.Scanner;

public class OneTableView {

    private Session session;

    public OneTableView(Session session) {
        this.session = session;
    }

    public void show(){

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter table name:");

        String number = myObj.nextLine();

        /*
         *       AIRLINE
         */
        if (number.equals("airline")) {
            AirlineController controller = new AirlineController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       AIRPlANE
         */
        if (number.equals("airplane")) {
            AirplaneController controller = new AirplaneController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       CATEGORY
         */
        if (number.equals("category")) {
            CategoryController controller = new CategoryController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       CITY
         */
        if (number.equals("city")) {
            CityController controller = new CityController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       COUNTRY
         */
        if (number.equals("country")) {
            CountryController controller = new CountryController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }



        /*
         *       CURRENT
         */
        if (number.equals("current")) {
            CurrentController controller = new CurrentController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       OWNER
         */
        if (number.equals("owner")) {
            OwnerController controller = new OwnerController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       PASSWORD
         */
        if (number.equals("password")) {
            PasswordController controller = new PasswordController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       POINT
         */
        if (number.equals("point")) {
            PointController controller = new PointController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }



        /*
         *       ROUTE
         */
        if (number.equals("route")) {
            RouteController controller = new RouteController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       TRAVELER
         */
        if (number.equals("traveler")) {
            TravelerController controller = new TravelerController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       SUPER ADMIN
         */
        if (number.equals("super_admin")) {
            SuperAdminController controller = new SuperAdminController(session);
            controller.read();

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }
        else {
            System.out.println("Table is not exist");
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }
    }
}
