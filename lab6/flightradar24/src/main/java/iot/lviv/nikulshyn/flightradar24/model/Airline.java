package iot.lviv.nikulshyn.flightradar24.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Airline {
    private Integer id;
    private Integer partership;
    private String name;
    private String registrationDate;
    private String registrationCountry;
    private Integer companyRevenue;
    private Owner ownerByOwnerId;
    private Collection<Airplane> airplanesById;
    private Collection<Traveler> travelersById;

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", partership=" + partership +
                ", name='" + name + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", registrationCountry='" + registrationCountry + '\'' +
                ", companyRevenue=" + companyRevenue +
                ", ownerByOwnerId=" + ownerByOwnerId +
                ", airplanesById=" + airplanesById +
                ", travelersById=" + travelersById +
                '}';
    }

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
    @Column(name = "partership", nullable = true)
    public Integer getPartership() {
        return partership;
    }

    public void setPartership(Integer partership) {
        this.partership = partership;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 105)
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
    @Column(name = "company_revenue", nullable = true)
    public Integer getCompanyRevenue() {
        return companyRevenue;
    }

    public void setCompanyRevenue(Integer companyRevenue) {
        this.companyRevenue = companyRevenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airline airline = (Airline) o;

        if (id != null ? !id.equals(airline.id) : airline.id != null) return false;
        if (partership != null ? !partership.equals(airline.partership) : airline.partership != null) return false;
        if (name != null ? !name.equals(airline.name) : airline.name != null) return false;
        if (registrationDate != null ? !registrationDate.equals(airline.registrationDate) : airline.registrationDate != null)
            return false;
        if (registrationCountry != null ? !registrationCountry.equals(airline.registrationCountry) : airline.registrationCountry != null)
            return false;
        if (companyRevenue != null ? !companyRevenue.equals(airline.companyRevenue) : airline.companyRevenue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (partership != null ? partership.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (registrationCountry != null ? registrationCountry.hashCode() : 0);
        result = 31 * result + (companyRevenue != null ? companyRevenue.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    public Owner getOwnerByOwnerId() {
        return ownerByOwnerId;
    }

    public void setOwnerByOwnerId(Owner ownerByOwnerId) {
        this.ownerByOwnerId = ownerByOwnerId;
    }

    @OneToMany(mappedBy = "airlineByAirlineId")
    public Collection<Airplane> getAirplanesById() {
        return airplanesById;
    }

    public void setAirplanesById(Collection<Airplane> airplanesById) {
        this.airplanesById = airplanesById;
    }

    @OneToMany(mappedBy = "airlineByAirlineId")
    public Collection<Traveler> getTravelersById() {
        return travelersById;
    }

    public void setTravelersById(Collection<Traveler> travelersById) {
        this.travelersById = travelersById;
    }
}
