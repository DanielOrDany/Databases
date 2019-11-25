package ua.lviv.iot.nikulshyn.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class City {
    private Integer id;
    private String name;
    private String region;
    private Country countryByCountryId;
    private Collection<Owner> ownersById;
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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "region", nullable = false, length = 45)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (region != null ? !region.equals(city.region) : city.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Owner> getOwnersById() {
        return ownersById;
    }

    public void setOwnersById(Collection<Owner> ownersById) {
        this.ownersById = ownersById;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Point> getPointsById() {
        return pointsById;
    }

    public void setPointsById(Collection<Point> pointsById) {
        this.pointsById = pointsById;
    }
}
