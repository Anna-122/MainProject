package com.solution.goncharova.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@code PublishingHouse} in package {@code com.solution.goncharova.entity}
 *
 * Create table users with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
@Entity
@Table(name = "`PublishingHouse`" , schema = "Book_Store_Hiber")
public class PublishingHouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publishingHouseId")
    private int publishingHouseId;

    @Column(name = "publishingHouseName")
    @NotNull
    @Size(min = 2, max = 30)
    private String publishingHouseName;

    @Column(name = "publishingHousePhoneNumber")
    @NotNull
    @Size(max = 15)
    private long publishingHousePhoneNumber;

    @Column(name = "publishingHouseStreet")
    @NotNull
    @Size(min = 2, max = 30)
    private String publishingHouseStreet;

    @Column(name = "publishingHouseNumber")
    @NotNull
    @Size(max = 5)
    private String publishingHouseNumber;

    @Column(name = "publishingHouseFlatNumber")
    @NotNull
    @Size(max = 5)
    private String publishingHouseFlatNumber;

    @Column(name = "publishingHousePostcode")
    @NotNull
    @Size(max = 10)
    private int publishingHousePostcode;


    @Column(name = "country_id")
    @NotNull
    @Size(max = 1)
    private int country_id;

    @Column(name = "city_id")
    @NotNull
    @Size(max = 1)
    private int city_id;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "countryId")
//    private Countries country;
//
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "cityId")
//    private Cities city;

    public PublishingHouse() {
    }

    public PublishingHouse(int publishingHouseId, String publishingHouseName, long publishingHousePhoneNumber, String publishingHouseStreet, String publishingHouseNumber, String publishingHouseFlatNumber, int publishingHousePostcode, int country_id, int city_id) {
        this.publishingHouseId = publishingHouseId;
        this.publishingHouseName = publishingHouseName;
        this.publishingHousePhoneNumber = publishingHousePhoneNumber;
        this.publishingHouseStreet = publishingHouseStreet;
        this.publishingHouseNumber = publishingHouseNumber;
        this.publishingHouseFlatNumber = publishingHouseFlatNumber;
        this.publishingHousePostcode = publishingHousePostcode;
        this.country_id = country_id;
        this.city_id = city_id;
    }

    public int getPublishingHouseId() {
        return publishingHouseId;
    }

    public void setPublishingHouseId(int publishingHouseId) {
        this.publishingHouseId = publishingHouseId;
    }

    public String getPublishingHouseName() {
        return publishingHouseName;
    }

    public void setPublishingHouseName(String publishingHouseName) {
        this.publishingHouseName = publishingHouseName;
    }

    public long getPublishingHousePhoneNumber() {
        return publishingHousePhoneNumber;
    }

    public void setPublishingHousePhoneNumber(long publishingHousePhoneNumber) {
        this.publishingHousePhoneNumber = publishingHousePhoneNumber;
    }

    public String getPublishingHouseStreet() {
        return publishingHouseStreet;
    }

    public void setPublishingHouseStreet(String publishingHouseStreet) {
        this.publishingHouseStreet = publishingHouseStreet;
    }

    public String getPublishingHouseNumber() {
        return publishingHouseNumber;
    }

    public void setPublishingHouseNumber(String publishingHouseNumber) {
        this.publishingHouseNumber = publishingHouseNumber;
    }

    public String getPublishingHouseFlatNumber() {
        return publishingHouseFlatNumber;
    }

    public void setPublishingHouseFlatNumber(String publishingHouseFlatNumber) {
        this.publishingHouseFlatNumber = publishingHouseFlatNumber;
    }

    public int getPublishingHousePostcode() {
        return publishingHousePostcode;
    }

    public void setPublishingHousePostcode(int publishingHousePostcode) {
        this.publishingHousePostcode = publishingHousePostcode;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "publishingHouseId=" + publishingHouseId +
                ", publishingHouseName='" + publishingHouseName + '\'' +
                ", publishingHousePhoneNumber=" + publishingHousePhoneNumber +
                ", publishingHouseStreet='" + publishingHouseStreet + '\'' +
                ", publishingHouseNumber='" + publishingHouseNumber + '\'' +
                ", publishingHouseFlatNumber='" + publishingHouseFlatNumber + '\'' +
                ", publishingHousePostcode=" + publishingHousePostcode +
                ", country_id=" + country_id +
                ", city_id=" + city_id +
                '}';
    }
}