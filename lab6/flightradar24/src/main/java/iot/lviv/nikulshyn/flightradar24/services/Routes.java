package iot.lviv.nikulshyn.flightradar24.services;

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
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@RestController
public class Routes {


    private Session session;

    /**
     *
     * Show data
     */

    @RequestMapping("/")
    public String flightradar(){
        return "flightradar24 by daniel";
    }

    @RequestMapping("/airline")
    public JSONArray airlineTable(){
        AirlineController controller = new AirlineController(this.session);
        return controller.read();
    }

    @RequestMapping("/airplane")
    public JSONArray airplaneTable(){
        AirplaneController controller = new AirplaneController(this.session);
        return controller.read();
    }

    @RequestMapping("/category")
    public JSONArray categoryTable(){
        CategoryController controller = new CategoryController(this.session);
        return controller.read();
    }

    @RequestMapping("/city")
    public JSONArray cityTable(){
        CityController controller = new CityController(this.session);
        return controller.read();
    }

    @RequestMapping("/country")
    public JSONArray countryTable(){
        CountryController controller = new CountryController(this.session);
        return controller.read();
    }

    @RequestMapping("/current")
    public JSONArray currentTable(){
        CurrentController controller = new CurrentController(this.session);
        return controller.read();
    }

    @RequestMapping("/owner")
    public JSONArray ownerTable(){
        OwnerController controller = new OwnerController(this.session);
        return controller.read();
    }

    @RequestMapping("/password")
    public JSONArray passwordTable(){
        PasswordController controller = new PasswordController(this.session);
        return controller.read();
    }

    @RequestMapping("/point")
    public JSONArray pointTable(){
        PointController controller = new PointController(this.session);
        return controller.read();
    }

    @RequestMapping("/route")
    public JSONArray routeTable(){
        RouteController controller = new RouteController(this.session);
        return controller.read();
    }

    @RequestMapping("/super_admin")
    public JSONArray adminTable(){
        SuperAdminController controller = new SuperAdminController(this.session);
        return controller.read();
    }

    @RequestMapping("/traveler")
    public JSONArray travelerTable(){
        TravelerController controller = new TravelerController(this.session);
        return controller.read();
    }

    /**
     *
     * Del data
     */
    @DeleteMapping(path= "/airline", consumes = "application/json", produces = "application/json")
    public void deleteAirline(@RequestBody Airline body) throws Exception {
        AirlineController controller = new AirlineController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/airplane", consumes = "application/json", produces = "application/json")
    public void deleteAirplane(@RequestBody Airplane body) throws Exception {
        AirplaneController controller = new AirplaneController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/category", consumes = "application/json", produces = "application/json")
    public void deleteCategory(@RequestBody AirplaneCategory body) throws Exception {
        CategoryController controller = new CategoryController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/city", consumes = "application/json", produces = "application/json")
    public void deleteCity(@RequestBody City body) throws Exception {
        CityController controller = new CityController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/country", consumes = "application/json", produces = "application/json")
    public void deleteCountry(@RequestBody Country body) throws Exception {
        CountryController controller = new CountryController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/current", consumes = "application/json", produces = "application/json")
    public void deleteCurrent(@RequestBody Current body) throws Exception {
        CurrentController controller = new CurrentController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/owner", consumes = "application/json", produces = "application/json")
    public void deleteOwner(@RequestBody Owner body) throws Exception {
        OwnerController controller = new OwnerController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/password", consumes = "application/json", produces = "application/json")
    public void deletePassword(@RequestBody SecretPassword body) throws Exception {
        PasswordController controller = new PasswordController(session);
        controller.delete(body.getTravelerId());
    }

    @DeleteMapping(path= "/point", consumes = "application/json", produces = "application/json")
    public void deletePoint(@RequestBody Point body) throws Exception {
        PointController controller = new PointController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/route", consumes = "application/json", produces = "application/json")
    public void deleteRoute(@RequestBody Route body) throws Exception {
        RouteController controller = new RouteController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/super_admin", consumes = "application/json", produces = "application/json")
    public void deleteAdmin(@RequestBody SuperAdmin body) throws Exception {
        SuperAdminController controller = new SuperAdminController(session);
        controller.delete(body.getId());
    }

    @DeleteMapping(path= "/traveler", consumes = "application/json", produces = "application/json")
    public void deleteTraveler(@RequestBody Traveler body) throws Exception {
        TravelerController controller = new TravelerController(session);
        controller.delete(body.getId());
    }

    /**
     *
     * Create data
     */

    @PostMapping(path= "/airplane", consumes = "application/json", produces = "application/json")
    public void addAirplane(@RequestBody Airplane body) throws Exception {
        AirplaneController controller = new AirplaneController(session);
        controller.create(body);
    }

    @PostMapping(path= "/category", consumes = "application/json", produces = "application/json")
    public void addCategory(@RequestBody AirplaneCategory body) throws Exception {
        CategoryController controller = new CategoryController(session);
        controller.create(body);
    }

    @PostMapping(path= "/city", consumes = "application/json", produces = "application/json")
    public void addCity(@RequestBody City body) throws Exception {
        CityController controller = new CityController(session);
        controller.create(body);
    }

    @PostMapping(path= "/country", consumes = "application/json", produces = "application/json")
    public void addCountry(@RequestBody Country body) throws Exception {
        CountryController controller = new CountryController(session);
        controller.create(body);
    }

    @PostMapping(path= "/current", consumes = "application/json", produces = "application/json")
    public void addCurrent(@RequestBody Current body) throws Exception {
        CurrentController controller = new CurrentController(session);
        controller.create(body);
    }

    @PostMapping(path= "/owner", consumes = "application/json", produces = "application/json")
    public void addOwner(@RequestBody Owner body) throws Exception {
        OwnerController controller = new OwnerController(session);
        controller.create(body);
    }

    @PostMapping(path= "/password", consumes = "application/json", produces = "application/json")
    public void addPassword(@RequestBody SecretPassword body) throws Exception {
        PasswordController controller = new PasswordController(session);
        controller.create(body);
    }

    @PostMapping(path= "/point", consumes = "application/json", produces = "application/json")
    public void addPoint(@RequestBody Point body) throws Exception {
        PointController controller = new PointController(session);
        controller.create(body);
    }

    @PostMapping(path= "/route", consumes = "application/json", produces = "application/json")
    public void addRoute(@RequestBody Route body) throws Exception {
        RouteController controller = new RouteController(session);
        controller.create(body);
    }

    @PostMapping(path= "/super_admin", consumes = "application/json", produces = "application/json")
    public void addAdmin(@RequestBody SuperAdmin body) throws Exception {
        SuperAdminController controller = new SuperAdminController(session);
        controller.create(body);
    }

    @PostMapping(path= "/traveler", consumes = "application/json", produces = "application/json")
    public void addTraveler(@RequestBody Traveler body) throws Exception {
        TravelerController controller = new TravelerController(session);
        controller.create(body);
    }

    /**
     *
     * Update data
     */
    @PostMapping(path= "/airplane/update", consumes = "application/json", produces = "application/json")
    public void updateAirplane(@RequestBody Airplane body) throws Exception {
        AirplaneController controller = new AirplaneController(session);
        controller.update(body);
    }

    @PostMapping(path= "/category/update", consumes = "application/json", produces = "application/json")
    public void updateCategory(@RequestBody AirplaneCategory body) throws Exception {
        CategoryController controller = new CategoryController(session);
        controller.update(body);
    }

    @PostMapping(path= "/city/update", consumes = "application/json", produces = "application/json")
    public void updateCity(@RequestBody City body) throws Exception {
        CityController controller = new CityController(session);
        controller.update(body);
    }

    @PostMapping(path= "/country/update", consumes = "application/json", produces = "application/json")
    public void updateCountry(@RequestBody Country body) throws Exception {
        CountryController controller = new CountryController(session);
        controller.update(body);
    }

    @PostMapping(path= "/current/update", consumes = "application/json", produces = "application/json")
    public void updateCurrent(@RequestBody Current body) throws Exception {
        CurrentController controller = new CurrentController(session);
        controller.update(body);
    }

    @PostMapping(path= "/owner/update", consumes = "application/json", produces = "application/json")
    public void updateOwner(@RequestBody Owner body) throws Exception {
        OwnerController controller = new OwnerController(session);
        controller.update(body);
    }

    @PostMapping(path= "/password/update", consumes = "application/json", produces = "application/json")
    public void updatePassword(@RequestBody SecretPassword body) throws Exception {
        PasswordController controller = new PasswordController(session);
        controller.update(body);
    }

    @PostMapping(path= "/point/update", consumes = "application/json", produces = "application/json")
    public void updatePoint(@RequestBody Point body) throws Exception {
        PointController controller = new PointController(session);
        controller.update(body);
    }

    @PostMapping(path= "/route/update", consumes = "application/json", produces = "application/json")
    public void updateRoute(@RequestBody Route body) throws Exception {
        RouteController controller = new RouteController(session);
        controller.update(body);
    }

    @PostMapping(path= "/super_admin/update", consumes = "application/json", produces = "application/json")
    public void updateAdmin(@RequestBody SuperAdmin body) throws Exception {
        SuperAdminController controller = new SuperAdminController(session);
        controller.update(body);
    }

    @PostMapping(path= "/traveler/update", consumes = "application/json", produces = "application/json")
    public void updateTraveler(@RequestBody Traveler body) throws Exception {
        TravelerController controller = new TravelerController(session);
        controller.update(body);
    }
}
