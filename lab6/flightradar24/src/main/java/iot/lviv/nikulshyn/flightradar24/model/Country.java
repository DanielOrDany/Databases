package iot.lviv.nikulshyn.flightradar24.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Country {
    private Integer id;
    private String name;
    private String language;
    private Collection<City> citiesById;
    private Collection<Owner> ownersById;

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
    @Column(name = "language", nullable = false, length = 45)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != null ? !id.equals(country.id) : country.id != null) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (language != null ? !language.equals(country.language) : country.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<City> getCitiesById() {
        return citiesById;
    }

    public void setCitiesById(Collection<City> citiesById) {
        this.citiesById = citiesById;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<Owner> getOwnersById() {
        return ownersById;
    }

    public void setOwnersById(Collection<Owner> ownersById) {
        this.ownersById = ownersById;
    }
}
