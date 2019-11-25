package iot.lviv.nikulshyn.flightradar24.model;

import javax.persistence.*;

@Entity
@Table(name = "secret_password", schema = "flightradar24", catalog = "")
public class SecretPassword {
    private String password;
    private Integer travelerId;
    private Traveler travelerByTravelerId;

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @Column(name = "traveler_id", nullable = false)
    public Integer getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(Integer travelerId) {
        this.travelerId = travelerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecretPassword that = (SecretPassword) o;

        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (travelerId != null ? !travelerId.equals(that.travelerId) : that.travelerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + (travelerId != null ? travelerId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "traveler_id", referencedColumnName = "id", nullable = false)
    public Traveler getTravelerByTravelerId() {
        return travelerByTravelerId;
    }

    public void setTravelerByTravelerId(Traveler travelerByTravelerId) {
        this.travelerByTravelerId = travelerByTravelerId;
    }
}
