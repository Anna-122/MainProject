package com.solution.goncharova.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Class {@code Cities} in package {@code com.solution.goncharova.entity}
 *
 * Create table users with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
@Entity
@Table(name = "Cities", schema = "Book_Store_Hiber")
public class Cities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    private int cityId;

    @Column(name = "city")
    @NotNull
    @Size(min = 2, max = 30)
    private String city;

    @Column(name = "country_id")
    @NotNull
    @Size(max = 1)
    private int country_id;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "countryId")
//    private Countries country;


    public Cities() {

    }

    public Cities(int cityId, String city, int country_id) {
        this.cityId = cityId;
        this.city = city;
        this.country_id = country_id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                ", country_id=" + country_id +
                '}';
    }
}
