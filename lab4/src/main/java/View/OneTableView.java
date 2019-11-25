package View;

import Model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class OneTableView {
    public void show(){

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter table name:");

        String number = myObj.nextLine();

        /*
         *       AIRLINE
         */
        if (number.equals("airline")) {

            AirlineModel airline = new AirlineModel();
            JSONArray airlineTable = airline.getTable();
            System.out.println("\n                                          AIRLINE\n");
            System.out.println("ID" + "   " + "Partnership" + "    " + "Name" + "    " + "Registration date" + "    " + "Registration country" + "    " + "Company revenue" + "    " + "Owner");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (Object o : airlineTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String airlineID = (String) jsonLineItem.get("id");
                String partnership = (String) jsonLineItem.get("partnership");
                String name = (String) jsonLineItem.get("name");
                String registrationDate = (String) jsonLineItem.get("registrationDate");
                String registrationCountry = (String) jsonLineItem.get("registrationCountry");
                String companyRevenue = (String) jsonLineItem.get("companyRevenue");
                String ownerId = (String) jsonLineItem.get("ownerId");
                System.out.println(airlineID + "  |  " + partnership + "  |  " + name + "  |  " + registrationDate + "  |  " + registrationCountry + "  |  " + companyRevenue + "  |  " + ownerId);
            }

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }

        /*
         *       AIRPlANE
         */
        if (number.equals("airplane")) {
            AirplaneModel airplane = new AirplaneModel();
            JSONArray airplaneTable = airplane.getTable();
            System.out.println("\n\n                                          AIRPLAN\n");
            System.out.println("ID" + "    " + "Name" + "    " + "Registration date" + "    " + "Registration country" + "    " + "Serial number" + "    " + "Age" + "    " + "Airplane category ID" + "    " + "Airline ID" + "    " + "Route ID");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            for (Object o : airplaneTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String id = (String) jsonLineItem.get("id");
                String name = (String) jsonLineItem.get("name");
                String registrationDate = (String) jsonLineItem.get("registrationDate");
                String registrationCountry = (String) jsonLineItem.get("registrationCountry");
                String serialNumber = (String) jsonLineItem.get("serialNumber");
                String age = (String) jsonLineItem.get("age");
                String airplaneCategoryId = (String) jsonLineItem.get("airplaneCategoryId");
                String airlineId = (String) jsonLineItem.get("airlineId");
                String routeId = (String) jsonLineItem.get("routeId");
                System.out.println(id + "  |  " + name + "  |  " + registrationDate + "  |  " + registrationCountry + "  |  " + serialNumber + "  |  " + age + "  |  " + airplaneCategoryId + "  |  " + airlineId + "  |  " + routeId);
            }

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       CATEGORY
         */
        if (number.equals("category")) {
            CategoryModel category = new CategoryModel();
            JSONArray categoryTable = category.getTable();
            System.out.println("\n\n  CATEGORY\n");
            System.out.println("ID" + "    " + "Type");
            System.out.println("------------");
            for (Object o : categoryTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String id = (String) jsonLineItem.get("id");
                String type = (String) jsonLineItem.get("type");
                System.out.println(id + "  |  " + type);
            }
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }

        /*
         *       CITY
         */
        if (number.equals("city")) {
            CityModel city = new CityModel();
            JSONArray cityTable = city.getTable();
            System.out.println("\n\n        CITY\n");
            System.out.println("ID" + "    " + "Name" + "    " + "Region" + "    " + "Country ID");
            System.out.println("------------------------------------");
            for (Object o : cityTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String id = (String) jsonLineItem.get("id");
                String name = (String) jsonLineItem.get("name");
                String region = (String) jsonLineItem.get("region");
                String country = (String) jsonLineItem.get("countryId");
                System.out.println(id + "  |  " + name + "  |  " + region + "  |  " + country);
            }
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }

        /*
         *       COUNTRY
         */
        if (number.equals("country")) {
            CountryModel country = new CountryModel();
            JSONArray countryTable = country.getTable();
            System.out.println("\n\n        COUNTRY\n");
            System.out.println("ID" + "    " + "Name" + "    " + "Language");
            System.out.println("--------------------------------");
            for (Object o : countryTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String id = (String) jsonLineItem.get("id");
                String name = (String) jsonLineItem.get("name");
                String language = (String) jsonLineItem.get("language");
                System.out.println(id + "  |  " + name + "  |  " + language);
            }
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }



        /*
         *       CURRENT
         */
        if (number.equals("current")) {
            CurrentModel current = new CurrentModel();
            JSONArray currentTable = current.getTable();
            System.out.println("\n\n                                          CURRENT\n");
            System.out.println("ID" + "    " + "Wind" + "    " + "Temperature" + "    " + "Latitude" + "    " + "Vertical speed" + "    " + "Gps altitude" + "    " + "Track" + "    " + "Ground speed" + "    " + "True speed" + "    " + "Indicated speed" + "    " + "March" + "    " + "Calibrated altitude" + "    " + "Icao" + "    " + "Squawk" + "    " + "Date time" + "    " + "Airplane ID");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Object o : currentTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String id = (String) jsonLineItem.get("id");
                String wind = (String) jsonLineItem.get("wind");
                String latitude = (String) jsonLineItem.get("latitude");
                String longtitude = (String) jsonLineItem.get("longtitude");
                String gps_altitude = (String) jsonLineItem.get("gpsAltitude");
                String track = (String) jsonLineItem.get("track");
                String ground_speed = (String) jsonLineItem.get("groundSpeed");
                String true_speed = (String) jsonLineItem.get("trueSpeed");
                String indicated_speed = (String) jsonLineItem.get("indicatedSpeed");
                String march = (String) jsonLineItem.get("march");
                String calibrated_altitude = (String) jsonLineItem.get("calibratedAltitude");
                String icao = (String) jsonLineItem.get("icao");
                String squawk = (String) jsonLineItem.get("squawk");
                String date_time = (String) jsonLineItem.get("dateTime");
                String airplane_id = (String) jsonLineItem.get("airplaneId");
                System.out.println(id + "  |  " + wind + "  |  " + latitude + "  |  " + longtitude + "  |  " + gps_altitude + "  |  " + track + "  |  " +ground_speed + "  |  " + true_speed + "  |  " + indicated_speed + "  |  " + march + "  |  " + calibrated_altitude + "  |  " + icao + "  |  " + squawk + "  |  " + date_time + "  |  " + airplane_id);
            }
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       OWNER
         */
        if (number.equals("owner")) {
            OwnerModel owner = new OwnerModel();
            JSONArray ownerTable = owner.getTable();
            System.out.println("\n\n        OWNER\n");
            System.out.println("ID" + "    " + "Full name" + "    " + "Age" + "    " + "Live adress" + "    " + "Email" + "    " + "Phone" + "    " + "Country ID" + "    " + "City ID");
            System.out.println("------------------------------------------------------------------------------------------------------");
            for (Object o : ownerTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String id = (String) jsonLineItem.get("id");
                String fullName = (String) jsonLineItem.get("full_name");
                String age = (String) jsonLineItem.get("age");
                String liveAdress = (String) jsonLineItem.get("live_adress");
                String email = (String) jsonLineItem.get("email");
                String phone = (String) jsonLineItem.get("phone");
                String countryId = (String) jsonLineItem.get("country_id");
                String cityId = (String) jsonLineItem.get("city_id");
                System.out.println(id + "  |  " + fullName + "  |  " + age + "  |  " + liveAdress + "  |  " + email + "  |  " + phone + "  |  " + countryId + "  |  " + cityId);
            }

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       PASSWORD
         */
        if (number.equals("password")) {
            PasswordModel password = new PasswordModel();
            JSONArray passwordTable = password.getTable();
            System.out.println("\n\n        PASSWORD\n");
            System.out.println("Password" + "    " + "Traveler ID");
            System.out.println("------------------------");
            for (Object o : passwordTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String password1 = (String) jsonLineItem.get("password");
                String travelerId = (String) jsonLineItem.get("traveler_id");
                System.out.println(password1 + "  |  " + travelerId);
            }

            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       POINT
         */
        if (number.equals("point")) {
            PointModel point = new PointModel();
            JSONArray pointTable = point.getTable();
            System.out.println("\n\n           POINT\n");
            System.out.println("ID" + "    " + "Airport" + "    " + "Route ID" + "    " + "City ID");
            System.out.println("-------------------------------------------");
            for (Object o : pointTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String id = (String) jsonLineItem.get("id");
                String airport = (String) jsonLineItem.get("airport");
                String routeId = (String) jsonLineItem.get("route_id");
                String cityId = (String) jsonLineItem.get("city_id");
                System.out.println(id + "  |  " + airport + "  |  " + routeId + "  |  " + cityId);
            }
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }



        /*
         *       ROUTE
         */
        if (number.equals("route")) {
            RouteModel route = new RouteModel();
            JSONArray routeTable = route.getTable();
            System.out.println("\n\n            ROUTE\n");
            System.out.println("ID" + "    " + "Scheduled from" + "    " + "Scheduled to" + "    " + "actual" + "    " + "estimated" + "    " + "Departure from" + "    " + "Arrival to" + "    " + "Total distance" + "    " + "Passed distance" + "    " + "Date");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            for (Object o : routeTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String id = (String) jsonLineItem.get("id");
                String scheduledFrom = (String) jsonLineItem.get("scheduled_from");
                String scheduledTo = (String) jsonLineItem.get("scheduled_to");
                String actual = (String) jsonLineItem.get("actual");
                String estimated = (String) jsonLineItem.get("estimated");
                String departureFrom = (String) jsonLineItem.get("departure_from");
                String arrivalTo = (String) jsonLineItem.get("arrival_to");
                String totalDistance = (String) jsonLineItem.get("total_distance");
                String passedDistance = (String) jsonLineItem.get("passed_distance");
                String date = (String) jsonLineItem.get("date");
                System.out.println(id + "  |  " + scheduledFrom + "  |  " + scheduledTo + "  |  " + actual + "  |  " + estimated + "  |  " + departureFrom + "  |  " + arrivalTo + "  |  " + totalDistance + "  |  " + passedDistance + "  |  " + date);
            }
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       TRAVELER
         */
        if (number.equals("traveler")) {
            TravelerModel traveler = new TravelerModel();
            JSONArray travelerTable = traveler.getTable();
            System.out.println("\n\n           TRAVELER\n");
            System.out.println("ID" + "    " + "Full name" + "    " + "Email" + "    " + "Language" + "    " + "Photo" + "    " + "Sub end" + "    " + "Plan" + "    " + "Started at" + "    " + "Updated at" + "    " + "Deleted at" + "    " + "Sub start" + "    " + "Airplane ID" + "    " + "Airline ID");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Object o : travelerTable) {
                JSONObject jsonLineItem = (JSONObject) o;
                String id = (String) jsonLineItem.get("id");
                String fullName = (String) jsonLineItem.get("full_name");
                String email = (String) jsonLineItem.get("email");
                String language = (String) jsonLineItem.get("language");
                String photoUrl = (String) jsonLineItem.get("photo_url");
                String subscriptionEnd = (String) jsonLineItem.get("subscription_end");
                String plan = (String) jsonLineItem.get("plan");
                String startAt = (String) jsonLineItem.get("start_at");
                String updatedAt = (String) jsonLineItem.get("updated_at");
                String deletedAt = (String) jsonLineItem.get("deleted_at");
                String subscriptionStart = (String) jsonLineItem.get("subscription_start");
                String airplaneId = (String) jsonLineItem.get("airplane_id");
                String airlineId = (String) jsonLineItem.get("airline_id");
                System.out.println(id + "  |  " + fullName + "  |  " + email + "  |  " + language + "  |  " + photoUrl + "  |  " + subscriptionEnd + "  |  " + plan + "  |  " + startAt + "  |  " + updatedAt + "  |  " + deletedAt + "  |  " + subscriptionStart + "  |  " + airplaneId + "  |  " + airlineId);
            }
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
