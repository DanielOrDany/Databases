package View;

import Model.*;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateView {
    public void show(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter table name:");

        String number = myObj.nextLine();

        /*
         *       AIRLINE
         */
        if (number.equals("airline")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();
            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter partnership:");
            String partnership = myObj2.nextLine();
            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter name:");
            String name = myObj3.nextLine();
            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter reg-date:");
            String rd = myObj4.nextLine();
            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter reg-country:");
            String rc = myObj5.nextLine();
            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter company-revenue:");
            String cr = myObj6.nextLine();
            //--
            int newId = Integer.parseInt(id);
            int newPartnership = Integer.parseInt(partnership);
            int newCr = Integer.parseInt(cr);
            //--
            AirlineModel airline = new AirlineModel();
            airline.updateRow(newId,newPartnership,name,rd,rc,newCr);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }

        /*
         *       AIRPlANE
         */
        if (number.equals("airplane")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter name:");
            String name = myObj2.nextLine();

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter registrationDate:");
            String registrationDate = myObj3.nextLine();

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter registrationCountry:");
            String registrationCountry = myObj4.nextLine();

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter serialNumber:");
            String serialNumber = myObj5.nextLine();

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter age:");
            String age = myObj6.nextLine();

            //--
            int newId = Integer.parseInt(id);
            int newAge = Integer.parseInt(age);
            //--
            AirplaneModel airline = new AirplaneModel();
            airline.updateRow(newId, name, registrationDate, registrationCountry, serialNumber, newAge);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       CATEGORY
         */
        if (number.equals("category")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter type:");
            String type = myObj2.nextLine();
            //--
            int newId = Integer.parseInt(id);
            //--
            CategoryModel category = new CategoryModel();
            category.updateRow(newId,type);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }

        /*
         *       CITY
         */
        if (number.equals("city")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter name:");
            String name = myObj2.nextLine();

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter region:");
            String region = myObj3.nextLine();
            //--
            int newId = Integer.parseInt(id);
            //--
            CityModel city = new CityModel();
            city.updateRow(newId, name, region);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }

        /*
         *       COUNTRY
         */
        if (number.equals("country")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter name:");
            String name = myObj2.nextLine();

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter language:");
            String language = myObj3.nextLine();

            //--
            int newId = Integer.parseInt(id);
            //--
            CountryModel country = new CountryModel();
            country.updateRow(newId, name, language);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }



        /*
         *       CURRENT
         */
        if (number.equals("current")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter wind:");
            String wind = myObj2.nextLine();

            Scanner myObj0 = new Scanner(System.in);
            System.out.println("Enter temperature:");
            String temperature = myObj0.nextLine();

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter latitude:");
            String latitude = myObj3.nextLine();

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter longtitude:");
            String longtitude = myObj4.nextLine();

            Scanner myObj55 = new Scanner(System.in);
            System.out.println("Enter vertical_speed:");
            String vertical_speed = myObj55.nextLine();

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter gps_altitude:");
            String gps_altitude = myObj5.nextLine();

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter track:");
            String track = myObj6.nextLine();

            Scanner myObj7 = new Scanner(System.in);
            System.out.println("Enter ground_speed:");
            String ground_speed = myObj7.nextLine();

            Scanner myObj8 = new Scanner(System.in);
            System.out.println("Enter true_speed:");
            String true_speed = myObj8.nextLine();

            Scanner myObj9 = new Scanner(System.in);
            System.out.println("Enter indicated_speed:");
            String indicated_speed = myObj9.nextLine();

            Scanner myObj10 = new Scanner(System.in);
            System.out.println("Enter march:");
            String march = myObj10.nextLine();

            Scanner myObj11 = new Scanner(System.in);
            System.out.println("Enter calibrated_altitude:");
            String calibrated_altitude = myObj11.nextLine();

            Scanner myObj12 = new Scanner(System.in);
            System.out.println("Enter icao:");
            String icao = myObj12.nextLine();

            Scanner myObj13 = new Scanner(System.in);
            System.out.println("Enter squawk:");
            String squawk = myObj13.nextLine();

            Scanner myObj14 = new Scanner(System.in);
            System.out.println("Enter date_time:");
            String date_time = myObj14.nextLine();

            //--
            int newId = Integer.parseInt(id);
            int newWind = Integer.parseInt(wind);
            int newTem = Integer.parseInt(temperature);
            float newLatitude = Float.parseFloat(latitude);
            float newLongtitude = Float.parseFloat(longtitude);
            int newVerSpeed = Integer.parseInt(vertical_speed);
            int newGps = Integer.parseInt(gps_altitude);
            int newTrack = Integer.parseInt(track);
            int newGroundSp = Integer.parseInt(ground_speed);
            int newTrueSp = Integer.parseInt(true_speed);
            int newIndicatedSp = Integer.parseInt(indicated_speed);
            int newMarch = Integer.parseInt(march);
            int newCalibratedA = Integer.parseInt(calibrated_altitude);
            int newIcao = Integer.parseInt(icao);
            int newSquawk = Integer.parseInt(squawk);
            int newDateTime = Integer.parseInt(date_time);
            //--
            CurrentModel current = new CurrentModel();
            current.updateRow(newId, newWind, newTem, newLatitude, newLongtitude, newVerSpeed, newGps, newTrack, newGroundSp, newTrueSp, newIndicatedSp, newMarch, newCalibratedA, newIcao, newSquawk, newDateTime);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       OWNER
         */
        if (number.equals("owner")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter full_name:");
            String full_name = myObj2.nextLine();

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter age:");
            String age = myObj3.nextLine();

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter live_adress:");
            String live_adress = myObj4.nextLine();

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter email:");
            String email = myObj5.nextLine();

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter phone:");
            String phone = myObj6.nextLine();

            Scanner myObj7 = new Scanner(System.in);
            System.out.println("Enter country_id:");
            String country_id = myObj7.nextLine();

            Scanner myObj8 = new Scanner(System.in);
            System.out.println("Enter city_id:");
            String city_id = myObj8.nextLine();

            //--
            int newId = Integer.parseInt(id);
            int newAge = Integer.parseInt(age);
            int newCountry = Integer.parseInt(country_id);
            int newCity = Integer.parseInt(city_id);
            //--
            OwnerModel owner = new OwnerModel();
            owner.updateRow(newId, full_name, newAge, live_adress, email, phone, newCountry, newCity);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       PASSWORD
         */
        if (number.equals("password")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter password:");
            String password = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter traveler id:");
            String traveler_id = myObj2.nextLine();
            //--
            int newId = Integer.parseInt(traveler_id);
            //--
            PasswordModel pass = new PasswordModel();
            pass.updateRow(newId, password);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       POINT
         */
        if (number.equals("point")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter airport:");
            String airport = myObj2.nextLine();
            //--
            int newId = Integer.parseInt(id);
            //--
            PointModel p = new PointModel();
            p.updateRow(newId, airport);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       ROUTE
         */
        if (number.equals("route")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter scheduled_from:");
            String scheduled_from = myObj2.nextLine();

            Scanner myObj0 = new Scanner(System.in);
            System.out.println("Enter scheduled_to:");
            String scheduled_to = myObj0.nextLine();

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter actual:");
            String actual = myObj3.nextLine();

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter estimated:");
            String estimated = myObj4.nextLine();

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter departure_from:");
            String departure_from = myObj5.nextLine();

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter arrival_to:");
            String arrival_to = myObj6.nextLine();

            Scanner myObj7 = new Scanner(System.in);
            System.out.println("Enter total_distance:");
            String total_distance = myObj7.nextLine();

            Scanner myObj8 = new Scanner(System.in);
            System.out.println("Enter passed_distance:");
            String passed_distance = myObj8.nextLine();

            Scanner myObj9 = new Scanner(System.in);
            System.out.println("Enter date:");
            String date = myObj9.nextLine();
            //--
            int newId = Integer.parseInt(id);
            int newActual = Integer.parseInt(actual);
            int newEstimated = Integer.parseInt(estimated);
            int newTD = Integer.parseInt(total_distance);
            int newPD = Integer.parseInt(passed_distance);
            //--
            RouteModel p = new RouteModel();
            p.updateRow(newId, scheduled_from, scheduled_to, newActual, newEstimated, departure_from, arrival_to, newTD, newPD, date);
            //--
            GeneralMenu generalMenu = new GeneralMenu();
            generalMenu.show();
        }


        /*
         *       TRAVELER
         */
        if (number.equals("traveler")) {
            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            String id = myObj1.nextLine();

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter full_name:");
            String full_name = myObj2.nextLine();

            Scanner myObj0 = new Scanner(System.in);
            System.out.println("Enter email:");
            String email = myObj0.nextLine();

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter language:");
            String language = myObj3.nextLine();

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter photo_url:");
            String photo_url = myObj4.nextLine();

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter subscription_end:");
            String subscription_end = myObj5.nextLine();

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter plan:");
            String plan = myObj6.nextLine();

            Scanner myObj7 = new Scanner(System.in);
            System.out.println("Enter start_at:");
            String start_at = myObj7.nextLine();

            Scanner myObj8 = new Scanner(System.in);
            System.out.println("Enter updated_at:");
            String updated_at = myObj8.nextLine();

            Scanner myObj9 = new Scanner(System.in);
            System.out.println("Enter deleted_at:");
            String deleted_at = myObj9.nextLine();

            Scanner myObj10 = new Scanner(System.in);
            System.out.println("Enter subscription_start:");
            String subscription_start = myObj10.nextLine();

            //--
            int newId = Integer.parseInt(id);
            //--
            TravelerModel p = new TravelerModel();
            p.updateRow(newId, full_name, email, language, photo_url, subscription_end, plan, start_at, updated_at, deleted_at, subscription_start);
            //--
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
