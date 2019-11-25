package iot.lviv.nikulshyn.flightradar24.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Owner {
    private Integer id;
    private String fullName;
    private String age;
    private String liveAdress;
    private String email;
    private String phone;
    private Collection<Airline> airlinesById;
    private Country countryByCountryId;
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
    @Column(name = "full_name", nullable = false, length = 200)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "age", nullable = true, length = 45)
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "live_adress", nullable = true, length = 45)
    public String getLiveAdress() {
        return liveAdress;
    }

    public void setLiveAdress(String liveAdress) {
        this.liveAdress = liveAdress;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 100)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (id != null ? !id.equals(owner.id) : owner.id != null) return false;
        if (fullName != null ? !fullName.equals(owner.fullName) : owner.fullName != null) return false;
        if (age != null ? !age.equals(owner.age) : owner.age != null) return false;
        if (liveAdress != null ? !liveAdress.equals(owner.liveAdress) : owner.liveAdress != null) return false;
        if (email != null ? !email.equals(owner.email) : owner.email != null) return false;
        if (phone != null ? !phone.equals(owner.phone) : owner.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (liveAdress != null ? liveAdress.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ownerByOwnerId")
    public Collection<Airline> getAirlinesById() {
        return airlinesById;
    }

    public void setAirlinesById(Collection<Airline> airlinesById) {
        this.airlinesById = airlinesById;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
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
