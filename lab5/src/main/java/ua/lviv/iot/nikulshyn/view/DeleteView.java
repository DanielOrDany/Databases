package ua.lviv.iot.nikulshyn.view;

import org.hibernate.Session;
import ua.lviv.iot.nikulshyn.controller.Airline.AirlineController;
import ua.lviv.iot.nikulshyn.controller.Airplane.AirplaneController;
import ua.lviv.iot.nikulshyn.controller.Category.CategoryController;
import ua.lviv.iot.nikulshyn.controller.City.CityController;
import ua.lviv.iot.nikulshyn.controller.Country.CountryController;
import ua.lviv.iot.nikulshyn.controller.Current.CurrentController;
import ua.lviv.iot.nikulshyn.controller.Owner.OwnerController;
import ua.lviv.iot.nikulshyn.controller.Password.PasswordController;
import ua.lviv.iot.nikulshyn.controller.Point.PointController;
import ua.lviv.iot.nikulshyn.controller.Route.RouteController;
import ua.lviv.iot.nikulshyn.controller.SuperAdmin.SuperAdminController;
import ua.lviv.iot.nikulshyn.controller.Traveler.TravelerController;
import ua.lviv.iot.nikulshyn.model.Route;
import ua.lviv.iot.nikulshyn.model.SuperAdmin;
import ua.lviv.iot.nikulshyn.model.Traveler;

import java.util.Scanner;

public class DeleteView {

    private Session session;

    public DeleteView(Session session) {
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

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            controller.delete(row.nextInt());

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       AIRPlANE
         */
        if (number.equals("airplane")) {
            AirplaneController controller = new AirplaneController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       CATEGORY
         */
        if (number.equals("category")) {
            CategoryController controller = new CategoryController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       CITY
         */
        if (number.equals("city")) {
            CityController controller = new CityController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       COUNTRY
         */
        if (number.equals("country")) {
            CountryController controller = new CountryController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }



        /*
         *       CURRENT
         */
        if (number.equals("current")) {
            CurrentController controller = new CurrentController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       OWNER
         */
        if (number.equals("owner")) {
            OwnerController controller = new OwnerController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       PASSWORD
         */
        if (number.equals("password")) {
            PasswordController controller = new PasswordController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       POINT
         */
        if (number.equals("point")) {
            PointController controller = new PointController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }



        /*
         *       ROUTE
         */
        if (number.equals("route")) {
            RouteController controller = new RouteController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       TRAVELER
         */
        if (number.equals("traveler")) {
            TravelerController controller = new TravelerController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       SUPER ADMIN
         */
        if (number.equals("super_admin")) {
            SuperAdminController controller = new SuperAdminController(session);

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            controller.delete(newId);

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
