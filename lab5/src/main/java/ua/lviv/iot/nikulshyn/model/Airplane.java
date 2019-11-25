package ua.lviv.iot.nikulshyn.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Airplane {
    private Integer id;
    private String name;
    private String registrationDate;
    private String registrationCountry;
    private String serialNumber;
    private Integer age;
    private AirplaneCategory airplaneCategoryByAirplaneCategoryId;
    private Airline airlineByAirlineId;
    private Route routeByRouteId;
    private Collection<Current> currentsById;
    private Collection<Traveler> travelersById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "registration_date", nullable = false, length = 45)
    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "registration_country", nullable = false, length = 45)
    public String getRegistrationCountry() {
        return registrationCountry;
    }

    public void setRegistrationCountry(String registrationCountry) {
        this.registrationCountry = registrationCountry;
    }

    @Basic
    @Column(name = "serial_number", nullable = false, length = 200)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airplane airplane = (Airplane) o;

        if (id != null ? !id.equals(airplane.id) : airplane.id != null) return false;
        if (name != null ? !name.equals(airplane.name) : airplane.name != null) return false;
        if (registrationDate != null ? !registrationDate.equals(airplane.registrationDate) : airplane.registrationDate != null)
            return false;
        if (registrationCountry != null ? !registrationCountry.equals(airplane.registrationCountry) : airplane.registrationCountry != null)
            return false;
        if (serialNumber != null ? !serialNumber.equals(airplane.serialNumber) : airplane.serialNumber != null)
            return false;
        if (age != null ? !age.equals(airplane.age) : airplane.age != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (registrationCountry != null ? registrationCountry.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "airplane_category_id", referencedColumnName = "id")
    public AirplaneCategory getAirplaneCategoryByAirplaneCategoryId() {
        return airplaneCategoryByAirplaneCategoryId;
    }

    public void setAirplaneCategoryByAirplaneCategoryId(AirplaneCategory airplaneCategoryByAirplaneCategoryId) {
        this.airplaneCategoryByAirplaneCategoryId = airplaneCategoryByAirplaneCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    public Airline getAirlineByAirlineId() {
        return airlineByAirlineId;
    }

    public void setAirlineByAirlineId(Airline airlineByAirlineId) {
        this.airlineByAirlineId = airlineByAirlineId;
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }

    @OneToMany(mappedBy = "airplaneByAirplaneId")
    public Collection<Current> getCurrentsById() {
        return currentsById;
    }

    public void setCurrentsById(Collection<Current> currentsById) {
        this.currentsById = currentsById;
    }

    @OneToMany(mappedBy = "airplaneByAirplaneId")
    public Collection<Traveler> getTravelersById() {
        return travelersById;
    }

    public void setTravelersById(Collection<Traveler> travelersById) {
        this.travelersById = travelersById;
    }
}
