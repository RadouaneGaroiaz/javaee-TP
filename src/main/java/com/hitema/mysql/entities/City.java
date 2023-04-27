package com.hitema.mysql.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
    @Table(name = "city")
public class City {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "city_id", nullable = false)
    private Long id;

    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City() {
    }

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;


    public City(String city, LocalDateTime lastUpdate) {
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String country) {
        this.city = city;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("City{");
        sb.append("id=").append(id);
        sb.append(", city='").append(city).append('\'');
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append('}');
        return sb.toString();
    }
}
