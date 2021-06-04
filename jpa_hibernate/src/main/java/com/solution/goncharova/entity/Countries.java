package com.solution.goncharova.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Class {@code Countries} in package {@code com.solution.goncharova.entity}
 *
 * Create table users with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
@Entity
@Table(name = "Countries", schema = "Book_Store_Hiber")
public class Countries implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countryId")
    private int countryId;

    @Column(name = "country")
    @NotNull
    @Size(min = 2, max = 30)
    private String country;


    public Countries() {
    }

    public Countries(int countryId, String country) {
        this.countryId = countryId;
        this.country = country;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "countryId=" + countryId +
                ", country='" + country + '\'' +
                '}';
    }
}

