package ua.lviv.iot.nikulshyn.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Route {
    private Integer id;
    private String scheduledFrom;
    private String scheduledTo;
    private String actual;
    private String estimated;
    private String departureFrom;
    private String arrivalTo;
    private Integer totalDistance;
    private Integer passedDistance;
    private String date;
    private Collection<Airplane> airplanesById;
    private Collection<Point> pointsById;

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
    @Column(name = "scheduled_from", nullable = false, length = 45)
    public String getScheduledFrom() {
        return scheduledFrom;
    }

    public void setScheduledFrom(String scheduledFrom) {
        this.scheduledFrom = scheduledFrom;
    }

    @Basic
    @Column(name = "scheduled_to", nullable = false, length = 45)
    public String getScheduledTo() {
        return scheduledTo;
    }

    public void setScheduledTo(String scheduledTo) {
        this.scheduledTo = scheduledTo;
    }

    @Basic
    @Column(name = "actual", nullable = false, length = 45)
    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    @Basic
    @Column(name = "estimated", nullable = false, length = 45)
    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    @Basic
    @Column(name = "departure_from", nullable = false, length = 45)
    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    @Basic
    @Column(name = "arrival_to", nullable = false, length = 45)
    public String getArrivalTo() {
        return arrivalTo;
    }

    public void setArrivalTo(String arrivalTo) {
        this.arrivalTo = arrivalTo;
    }

    @Basic
    @Column(name = "total_distance", nullable = false)
    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    @Basic
    @Column(name = "passed_distance", nullable = false)
    public Integer getPassedDistance() {
        return passedDistance;
    }

    public void setPassedDistance(Integer passedDistance) {
        this.passedDistance = passedDistance;
    }

    @Basic
    @Column(name = "date", nullable = false, length = 45)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != null ? !id.equals(route.id) : route.id != null) return false;
        if (scheduledFrom != null ? !scheduledFrom.equals(route.scheduledFrom) : route.scheduledFrom != null)
            return false;
        if (scheduledTo != null ? !scheduledTo.equals(route.scheduledTo) : route.scheduledTo != null) return false;
        if (actual != null ? !actual.equals(route.actual) : route.actual != null) return false;
        if (estimated != null ? !estimated.equals(route.estimated) : route.estimated != null) return false;
        if (departureFrom != null ? !departureFrom.equals(route.departureFrom) : route.departureFrom != null)
            return false;
        if (arrivalTo != null ? !arrivalTo.equals(route.arrivalTo) : route.arrivalTo != null) return false;
        if (totalDistance != null ? !totalDistance.equals(route.totalDistance) : route.totalDistance != null)
            return false;
        if (passedDistance != null ? !passedDistance.equals(route.passedDistance) : route.passedDistance != null)
            return false;
        if (date != null ? !date.equals(route.date) : route.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (scheduledFrom != null ? scheduledFrom.hashCode() : 0);
        result = 31 * result + (scheduledTo != null ? scheduledTo.hashCode() : 0);
        result = 31 * result + (actual != null ? actual.hashCode() : 0);
        result = 31 * result + (estimated != null ? estimated.hashCode() : 0);
        result = 31 * result + (departureFrom != null ? departureFrom.hashCode() : 0);
        result = 31 * result + (arrivalTo != null ? arrivalTo.hashCode() : 0);
        result = 31 * result + (totalDistance != null ? totalDistance.hashCode() : 0);
        result = 31 * result + (passedDistance != null ? passedDistance.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<Airplane> getAirplanesById() {
        return airplanesById;
    }

    public void setAirplanesById(Collection<Airplane> airplanesById) {
        this.airplanesById = airplanesById;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<Point> getPointsById() {
        return pointsById;
    }

    public void setPointsById(Collection<Point> pointsById) {
        this.pointsById = pointsById;
    }
}
