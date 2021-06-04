package com.solution.goncharova.entity;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@code UserType} in package {@code com.solution.goncharova.entity}
 *
 * Create table users with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
@Entity
@Table(name = "`UserType`" , schema = "Book_Store_Hiber")
public class UserType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userTypeId")
    private int userTypeId;

    @Column(name = "userType")
    @NotNull
    @Size(min = 2, max = 30)
    private String userType;

    public UserType() {

    }

    public UserType(int userTypeId, String userType) {
        this.userTypeId = userTypeId;
        this.userType = userType;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", userType='" + userType + '\'' +
                '}';
    }
}
