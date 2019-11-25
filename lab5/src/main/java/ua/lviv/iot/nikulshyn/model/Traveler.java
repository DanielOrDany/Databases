package ua.lviv.iot.nikulshyn.model;

import javax.persistence.*;

@Entity
public class Traveler {
    private Integer id;
    private String fullName;
    private String email;
    private String language;
    private String photoUrl;
    private String subscriptionEnd;
    private String plan;
    private String startAt;
    private String updatedAt;
    private String deletedAt;
    private String subscriptionStart;
    private SecretPassword secretPasswordById;
    private Airplane airplaneByAirplaneId;
    private Airline airlineByAirlineId;

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
    @Column(name = "email", nullable = false, length = 105)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "language", nullable = false, length = 45)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "photo_url", nullable = false, length = 45)
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Basic
    @Column(name = "subscription_end", nullable = false, length = 45)
    public String getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(String subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }

    @Basic
    @Column(name = "plan", nullable = false, length = 45)
    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    @Basic
    @Column(name = "start_at", nullable = false, length = 45)
    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = true, length = 45)
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "deleted_at", nullable = true, length = 45)
    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Basic
    @Column(name = "subscription_start", nullable = false, length = 45)
    public String getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(String subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Traveler traveler = (Traveler) o;

        if (id != null ? !id.equals(traveler.id) : traveler.id != null) return false;
        if (fullName != null ? !fullName.equals(traveler.fullName) : traveler.fullName != null) return false;
        if (email != null ? !email.equals(traveler.email) : traveler.email != null) return false;
        if (language != null ? !language.equals(traveler.language) : traveler.language != null) return false;
        if (photoUrl != null ? !photoUrl.equals(traveler.photoUrl) : traveler.photoUrl != null) return false;
        if (subscriptionEnd != null ? !subscriptionEnd.equals(traveler.subscriptionEnd) : traveler.subscriptionEnd != null)
            return false;
        if (plan != null ? !plan.equals(traveler.plan) : traveler.plan != null) return false;
        if (startAt != null ? !startAt.equals(traveler.startAt) : traveler.startAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(traveler.updatedAt) : traveler.updatedAt != null) return false;
        if (deletedAt != null ? !deletedAt.equals(traveler.deletedAt) : traveler.deletedAt != null) return false;
        if (subscriptionStart != null ? !subscriptionStart.equals(traveler.subscriptionStart) : traveler.subscriptionStart != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
        result = 31 * result + (subscriptionEnd != null ? subscriptionEnd.hashCode() : 0);
        result = 31 * result + (plan != null ? plan.hashCode() : 0);
        result = 31 * result + (startAt != null ? startAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
        result = 31 * result + (subscriptionStart != null ? subscriptionStart.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "travelerByTravelerId")
    public SecretPassword getSecretPasswordById() {
        return secretPasswordById;
    }

    public void setSecretPasswordById(SecretPassword secretPasswordById) {
        this.secretPasswordById = secretPasswordById;
    }

    @ManyToOne
    @JoinColumn(name = "airplane_id", referencedColumnName = "id")
    public Airplane getAirplaneByAirplaneId() {
        return airplaneByAirplaneId;
    }

    public void setAirplaneByAirplaneId(Airplane airplaneByAirplaneId) {
        this.airplaneByAirplaneId = airplaneByAirplaneId;
    }

    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    public Airline getAirlineByAirlineId() {
        return airlineByAirlineId;
    }

    public void setAirlineByAirlineId(Airline airlineByAirlineId) {
        this.airlineByAirlineId = airlineByAirlineId;
    }
}
