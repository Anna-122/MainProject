package com.solution.goncharova.entity;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@code Storage} in package {@code com.solution.goncharova.entity}
 *
 * Create table users with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
@Entity
@Table(name = "`Storage`" , schema = "Book_Store_Hiber")
public class Storage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storageId")
    private int storageId;

    @Column(name = "bookId")
    @NotNull
    @Size( max = 1)
    private int bookId;

    @Column(name = "bookCount")
    @NotNull
    private int bookCount;

    @Column(name = "storageStreet")
    @NotNull
    @Size(min = 2, max = 30)
    private String storageStreet;

    @Column(name = "storageHouseNumber")
    @NotNull
    private String storageHouseNumber;

    @Column(name = "storageFlatNumber")
    @NotNull
    @Size( max = 5)
    private String storageFlatNumber;

    @Column(name = "country_id")
    @NotNull
    @Size( max = 1)
    private int country_id;

    @Column(name = "city_id")
    @NotNull
    @Size( max = 1)
    private int city_id;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "countryId")
//    private Countries country;
//
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "cityId")
//    private Cities city;

    public Storage() {
    }

    public Storage(int storageId, int bookId, int bookCount, String storageStreet, String storageHouseNumber, String storageFlatNumber, int country_id, int city_id) {
        this.storageId = storageId;
        this.bookId = bookId;
        this.bookCount = bookCount;
        this.storageStreet = storageStreet;
        this.storageHouseNumber = storageHouseNumber;
        this.storageFlatNumber = storageFlatNumber;
        this.country_id = country_id;
        this.city_id = city_id;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public String getStorageStreet() {
        return storageStreet;
    }

    public void setStorageStreet(String storageStreet) {
        this.storageStreet = storageStreet;
    }

    public String getStorageHouseNumber() {
        return storageHouseNumber;
    }

    public void setStorageHouseNumber(String storageHouseNumber) {
        this.storageHouseNumber = storageHouseNumber;
    }

    public String getStorageFlatNumber() {
        return storageFlatNumber;
    }

    public void setStorageFlatNumber(String storageFlatNumber) {
        this.storageFlatNumber = storageFlatNumber;
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
        return "Storage{" +
                "storageId=" + storageId +
                ", bookId=" + bookId +
                ", bookCount=" + bookCount +
                ", storageStreet='" + storageStreet + '\'' +
                ", storageHouseNumber=" + storageHouseNumber +
                ", storageFlatNumber='" + storageFlatNumber + '\'' +
                ", country_id=" + country_id +
                ", city_id=" + city_id +
                '}';
    }
}
