package com.hitema.mysql.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
    @Table(name = "country")
public class Country {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "country_id", nullable = false)
    private Long id;

    private String country;

    public Country() {
    }

    public Country(String country, LocalDateTime lastUpdate) {
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Country{");
        sb.append("id=").append(id);
        sb.append(", country='").append(country).append('\'');
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append('}');
        return sb.toString();
    }
}
