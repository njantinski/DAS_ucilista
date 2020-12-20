package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class School {

    @Id
    private Long id;
    private String name;
    private Double longitude;
    private Double latitude;


    public School() {
    }

    public School( Long id,Double longitude, Double latitude,String name){
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;
        School school = (School) o;
        return id.equals(school.id) &&
                name.equals(school.name) &&
                longitude.equals(school.longitude) &&
                latitude.equals(school.latitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, longitude, latitude);
    }
}
