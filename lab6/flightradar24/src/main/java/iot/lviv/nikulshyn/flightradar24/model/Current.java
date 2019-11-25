package iot.lviv.nikulshyn.flightradar24.model;

import javax.persistence.*;

@Entity
public class Current {
    private Integer id;
    private Integer wind;
    private Integer temperature;
    private Double latitude;
    private Double longtitude;
    private Integer verticalSpeed;
    private Integer gpsAltitude;
    private Integer track;
    private Integer groundSpeed;
    private Integer trueSpeed;
    private Integer indicatedSpeed;
    private Integer march;
    private Integer calibratedAltitude;
    private Integer icao;
    private Integer squawk;
    private String dateTime;
    private Airplane airplaneByAirplaneId;

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
    @Column(name = "wind", nullable = false)
    public Integer getWind() {
        return wind;
    }

    public void setWind(Integer wind) {
        this.wind = wind;
    }

    @Basic
    @Column(name = "temperature", nullable = false)
    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "latitude", nullable = false, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longtitude", nullable = false, precision = 0)
    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    @Basic
    @Column(name = "vertical_speed", nullable = false)
    public Integer getVerticalSpeed() {
        return verticalSpeed;
    }

    public void setVerticalSpeed(Integer verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    @Basic
    @Column(name = "gps_altitude", nullable = false)
    public Integer getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(Integer gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    @Basic
    @Column(name = "track", nullable = false)
    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    @Basic
    @Column(name = "ground_speed", nullable = false)
    public Integer getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(Integer groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    @Basic
    @Column(name = "true_speed", nullable = false)
    public Integer getTrueSpeed() {
        return trueSpeed;
    }

    public void setTrueSpeed(Integer trueSpeed) {
        this.trueSpeed = trueSpeed;
    }

    @Basic
    @Column(name = "indicated_speed", nullable = false)
    public Integer getIndicatedSpeed() {
        return indicatedSpeed;
    }

    public void setIndicatedSpeed(Integer indicatedSpeed) {
        this.indicatedSpeed = indicatedSpeed;
    }

    @Basic
    @Column(name = "march", nullable = false)
    public Integer getMarch() {
        return march;
    }

    public void setMarch(Integer march) {
        this.march = march;
    }

    @Basic
    @Column(name = "calibrated_altitude", nullable = false)
    public Integer getCalibratedAltitude() {
        return calibratedAltitude;
    }

    public void setCalibratedAltitude(Integer calibratedAltitude) {
        this.calibratedAltitude = calibratedAltitude;
    }

    @Basic
    @Column(name = "icao", nullable = false)
    public Integer getIcao() {
        return icao;
    }

    public void setIcao(Integer icao) {
        this.icao = icao;
    }

    @Basic
    @Column(name = "squawk", nullable = false)
    public Integer getSquawk() {
        return squawk;
    }

    public void setSquawk(Integer squawk) {
        this.squawk = squawk;
    }

    @Basic
    @Column(name = "date_time", nullable = false, length = 45)
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Current current = (Current) o;

        if (id != null ? !id.equals(current.id) : current.id != null) return false;
        if (wind != null ? !wind.equals(current.wind) : current.wind != null) return false;
        if (temperature != null ? !temperature.equals(current.temperature) : current.temperature != null) return false;
        if (latitude != null ? !latitude.equals(current.latitude) : current.latitude != null) return false;
        if (longtitude != null ? !longtitude.equals(current.longtitude) : current.longtitude != null) return false;
        if (verticalSpeed != null ? !verticalSpeed.equals(current.verticalSpeed) : current.verticalSpeed != null)
            return false;
        if (gpsAltitude != null ? !gpsAltitude.equals(current.gpsAltitude) : current.gpsAltitude != null) return false;
        if (track != null ? !track.equals(current.track) : current.track != null) return false;
        if (groundSpeed != null ? !groundSpeed.equals(current.groundSpeed) : current.groundSpeed != null) return false;
        if (trueSpeed != null ? !trueSpeed.equals(current.trueSpeed) : current.trueSpeed != null) return false;
        if (indicatedSpeed != null ? !indicatedSpeed.equals(current.indicatedSpeed) : current.indicatedSpeed != null)
            return false;
        if (march != null ? !march.equals(current.march) : current.march != null) return false;
        if (calibratedAltitude != null ? !calibratedAltitude.equals(current.calibratedAltitude) : current.calibratedAltitude != null)
            return false;
        if (icao != null ? !icao.equals(current.icao) : current.icao != null) return false;
        if (squawk != null ? !squawk.equals(current.squawk) : current.squawk != null) return false;
        if (dateTime != null ? !dateTime.equals(current.dateTime) : current.dateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wind != null ? wind.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longtitude != null ? longtitude.hashCode() : 0);
        result = 31 * result + (verticalSpeed != null ? verticalSpeed.hashCode() : 0);
        result = 31 * result + (gpsAltitude != null ? gpsAltitude.hashCode() : 0);
        result = 31 * result + (track != null ? track.hashCode() : 0);
        result = 31 * result + (groundSpeed != null ? groundSpeed.hashCode() : 0);
        result = 31 * result + (trueSpeed != null ? trueSpeed.hashCode() : 0);
        result = 31 * result + (indicatedSpeed != null ? indicatedSpeed.hashCode() : 0);
        result = 31 * result + (march != null ? march.hashCode() : 0);
        result = 31 * result + (calibratedAltitude != null ? calibratedAltitude.hashCode() : 0);
        result = 31 * result + (icao != null ? icao.hashCode() : 0);
        result = 31 * result + (squawk != null ? squawk.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "airplane_id", referencedColumnName = "id")
    public Airplane getAirplaneByAirplaneId() {
        return airplaneByAirplaneId;
    }

    public void setAirplaneByAirplaneId(Airplane airplaneByAirplaneId) {
        this.airplaneByAirplaneId = airplaneByAirplaneId;
    }
}
