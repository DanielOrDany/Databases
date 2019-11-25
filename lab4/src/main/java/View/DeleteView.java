package View;

import Model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class DeleteView {
    public void show(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter table name:");

        String number = myObj.nextLine();

        /*
         *       AIRLINE
         */
        if (number.equals("airline")) {
            AirlineModel airline = new AirlineModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            airline.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }

        /*
         *       AIRPlANE
         */
        if (number.equals("airplane")) {
            AirplaneModel airplane = new AirplaneModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            airplane.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       CATEGORY
         */
        if (number.equals("category")) {
            CategoryModel category = new CategoryModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            category.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }

        /*
         *       CITY
         */
        if (number.equals("city")) {
            CityModel city = new CityModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            city.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }

        /*
         *       COUNTRY
         */
        if (number.equals("country")) {
            CountryModel country = new CountryModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            country.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }



        /*
         *       CURRENT
         */
        if (number.equals("current")) {
            CurrentModel current = new CurrentModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            current.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       OWNER
         */
        if (number.equals("owner")) {
            OwnerModel owner = new OwnerModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            owner.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       PASSWORD
         */
        if (number.equals("password")) {
            PasswordModel password = new PasswordModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            password.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       POINT
         */
        if (number.equals("point")) {
            PointModel point = new PointModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            point.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }



        /*
         *       ROUTE
         */
        if (number.equals("route")) {
            RouteModel route = new RouteModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            route.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       TRAVELER
         */
        if (number.equals("traveler")) {
            TravelerModel traveler = new TravelerModel();

            Scanner row = new Scanner(System.in);
            System.out.println("Enter row id:");
            String id = row.nextLine();
            int newId = Integer.parseInt(id);
            traveler.deleteRow(newId);

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }
        else {
            System.out.println("Table is not exist");
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }
    }
}
