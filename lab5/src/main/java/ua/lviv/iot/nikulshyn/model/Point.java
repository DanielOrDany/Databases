package ua.lviv.iot.nikulshyn.model;

import javax.persistence.*;

@Entity
public class Point {
    private Integer id;
    private String airport;
    private Route routeByRouteId;
    private City cityByCityId;

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
    @Column(name = "airport", nullable = false, length = 45)
    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (id != null ? !id.equals(point.id) : point.id != null) return false;
        if (airport != null ? !airport.equals(point.airport) : point.airport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (airport != null ? airport.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false)
    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }
}
