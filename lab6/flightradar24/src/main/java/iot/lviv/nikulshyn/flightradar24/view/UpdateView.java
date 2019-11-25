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
import iot.lviv.nikulshyn.flightradar24.model.*;

import java.util.Scanner;

public class UpdateView {

    private Session session;

    public UpdateView(Session session) {
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
            Airline entity = new Airline();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter partnership:");
            entity.setPartership(myObj2.nextInt());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter name:");
            entity.setName(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter reg-date:");
            entity.setRegistrationDate(myObj4.nextLine());

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter reg-country:");
            entity.setRegistrationCountry(myObj5.nextLine());

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter company-revenue:");
            entity.setCompanyRevenue(myObj6.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       AIRPlANE
         */
        if (number.equals("airplane")) {
            AirplaneController controller = new AirplaneController(session);
            Airplane entity = new Airplane();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter name:");
            entity.setName(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter registrationDate:");
            entity.setRegistrationDate(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter registrationCountry:");
            entity.setRegistrationCountry(myObj4.nextLine());

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter serialNumber:");
            entity.setSerialNumber(myObj5.nextLine());

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter age:");
            entity.setAge(myObj6.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       CATEGORY
         */
        if (number.equals("category")) {
            CategoryController controller = new CategoryController(session);
            AirplaneCategory entity = new AirplaneCategory();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter type:");
            entity.setType(myObj2.nextLine());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       CITY
         */
        if (number.equals("city")) {
            CityController controller = new CityController(session);
            City entity = new City();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter name:");
            entity.setName(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter region:");
            entity.setRegion(myObj3.nextLine());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }

        /*
         *       COUNTRY
         */
        if (number.equals("country")) {
            CountryController controller = new CountryController(session);
            Country entity = new Country();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter name:");
            entity.setName(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter language:");
            entity.setLanguage(myObj3.nextLine());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }



        /*
         *       CURRENT
         */
        if (number.equals("current")) {
            CurrentController controller = new CurrentController(session);
            Current entity = new Current();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter wind:");
            entity.setWind(myObj2.nextInt());

            Scanner myObj0 = new Scanner(System.in);
            System.out.println("Enter temperature:");
            entity.setTemperature(myObj0.nextInt());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter latitude:");
            entity.setLatitude(myObj3.nextDouble());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter longtitude:");
            entity.setLongtitude(myObj4.nextDouble());

            Scanner myObj55 = new Scanner(System.in);
            System.out.println("Enter vertical_speed:");
            entity.setVerticalSpeed(myObj55.nextInt());

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter gps_altitude:");
            entity.setGpsAltitude(myObj5.nextInt());

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter track:");
            entity.setTrack(myObj6.nextInt());

            Scanner myObj7 = new Scanner(System.in);
            System.out.println("Enter ground_speed:");
            entity.setGroundSpeed(myObj7.nextInt());

            Scanner myObj8 = new Scanner(System.in);
            System.out.println("Enter true_speed:");
            entity.setTrueSpeed(myObj8.nextInt());

            Scanner myObj9 = new Scanner(System.in);
            System.out.println("Enter indicated_speed:");
            entity.setIndicatedSpeed(myObj9.nextInt());

            Scanner myObj10 = new Scanner(System.in);
            System.out.println("Enter march:");
            entity.setMarch(myObj10.nextInt());

            Scanner myObj11 = new Scanner(System.in);
            System.out.println("Enter calibrated_altitude:");
            entity.setCalibratedAltitude(myObj11.nextInt());

            Scanner myObj12 = new Scanner(System.in);
            System.out.println("Enter icao:");
            entity.setIcao(myObj12.nextInt());

            Scanner myObj13 = new Scanner(System.in);
            System.out.println("Enter squawk:");
            entity.setSquawk(myObj13.nextInt());

            Scanner myObj14 = new Scanner(System.in);
            System.out.println("Enter date_time:");
            entity.setDateTime(myObj14.nextLine());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       OWNER
         */
        if (number.equals("owner")) {
            OwnerController controller = new OwnerController(session);
            Owner entity = new Owner();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter full_name:");
            entity.setFullName(myObj2.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter age:");
            entity.setAge(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter live_adress:");
            entity.setLiveAdress(myObj4.nextLine());

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter email:");
            entity.setEmail(myObj5.nextLine());

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter phone:");
            entity.setPhone(myObj6.nextLine());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       PASSWORD
         */
        if (number.equals("password")) {
            PasswordController controller = new PasswordController(session);
            SecretPassword entity = new SecretPassword();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter password:");
            entity.setPassword(myObj1.nextLine());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter traveler id:");
            entity.setTravelerId(myObj2.nextInt());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       POINT
         */
        if (number.equals("point")) {
            PointController controller = new PointController(session);
            Point entity = new Point();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter airport:");
            entity.setAirport(myObj2.nextLine());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       ROUTE
         */
        if (number.equals("route")) {
            RouteController controller = new RouteController(session);
            Route entity = new Route();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter scheduled_from:");
            entity.setScheduledFrom(myObj2.nextLine());

            Scanner myObj0 = new Scanner(System.in);
            System.out.println("Enter scheduled_to:");
            entity.setScheduledTo(myObj0.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter actual:");
            entity.setActual(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter estimated:");
            entity.setEstimated(myObj4.nextLine());

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter departure_from:");
            entity.setDepartureFrom(myObj5.nextLine());

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter arrival_to:");
            entity.setArrivalTo(myObj6.nextLine());

            Scanner myObj7 = new Scanner(System.in);
            System.out.println("Enter total_distance:");
            entity.setTotalDistance(myObj7.nextInt());

            Scanner myObj8 = new Scanner(System.in);
            System.out.println("Enter passed_distance:");
            entity.setPassedDistance(myObj8.nextInt());

            Scanner myObj9 = new Scanner(System.in);
            System.out.println("Enter date:");
            entity.setDate(myObj9.nextLine());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       TRAVELER
         */
        if (number.equals("traveler")) {
            TravelerController controller = new TravelerController(session);
            Traveler entity = new Traveler();

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj1.nextInt());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter full_name:");
            entity.setFullName(myObj2.nextLine());

            Scanner myObj0 = new Scanner(System.in);
            System.out.println("Enter email:");
            entity.setEmail(myObj0.nextLine());

            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter language:");
            entity.setLanguage(myObj3.nextLine());

            Scanner myObj4 = new Scanner(System.in);
            System.out.println("Enter photo_url:");
            entity.setPhotoUrl(myObj4.nextLine());

            Scanner myObj5 = new Scanner(System.in);
            System.out.println("Enter subscription_end:");
            entity.setSubscriptionEnd(myObj5.nextLine());

            Scanner myObj6 = new Scanner(System.in);
            System.out.println("Enter plan:");
            entity.setPlan(myObj6.nextLine());

            Scanner myObj7 = new Scanner(System.in);
            System.out.println("Enter start_at:");
            entity.setStartAt(myObj7.nextLine());

            Scanner myObj8 = new Scanner(System.in);
            System.out.println("Enter updated_at:");
            entity.setUpdatedAt(myObj8.nextLine());

            Scanner myObj9 = new Scanner(System.in);
            System.out.println("Enter deleted_at:");
            entity.setDeletedAt(myObj9.nextLine());

            Scanner myObj10 = new Scanner(System.in);
            System.out.println("Enter subscription_start:");
            entity.setSubscriptionStart(myObj10.nextLine());
            //--
            controller.update(entity);
            //--
            GeneralMenu generalMenu = new GeneralMenu(session);
            generalMenu.show();
        }


        /*
         *       SUPER ADMIN
         */
        if (number.equals("super_admin")) {
            SuperAdminController controller = new SuperAdminController(session);
            SuperAdmin entity = new SuperAdmin();

            Scanner myObj0 = new Scanner(System.in);
            System.out.println("Enter id:");
            entity.setId(myObj0.nextInt());

            Scanner myObj1 = new Scanner(System.in);
            System.out.println("Enter name:");
            entity.setName(myObj1.nextLine());

            Scanner myObj2 = new Scanner(System.in);
            System.out.println("Enter password:");
            entity.setPassword(myObj2.nextLine());
            //--
            controller.update(entity);
            //--
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
