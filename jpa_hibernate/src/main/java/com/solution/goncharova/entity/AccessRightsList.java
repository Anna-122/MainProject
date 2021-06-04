package com.solution.goncharova.entity;

import jakarta.validation.constraints.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@code AccessRightsList} in package {@code com.solution.goncharova.entity}
 *
 * Create table users with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
@Entity
@Table(name = "Access_rights_list", schema = "Book_Store_Hiber")
public class AccessRightsList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userRightId")
    private int userRightId;

    @Column(name = "user_type_id")
    @NotNull
    @Size(max = 1)
    private int user_type_id;

    @Column(name = "rights")
    @NotNull
    @Size(min = 2, max = 30)
    private String rights;


//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "userTypeId")
//    private UserType userType;

    public AccessRightsList() {}

    public AccessRightsList(int userRightId, int user_type_id, String rights) {
        this.userRightId = userRightId;
        this.user_type_id = user_type_id;
        this.rights = rights;
    }

    public int getUserRightId() {
        return userRightId;
    }

    public void setUserRightId(int userRightId) {
        this.userRightId = userRightId;
    }

    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(int user_type_id) {
        this.user_type_id = user_type_id;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    @Override
    public String toString() {
        return "AccessRightsList{" +
                "userRightId=" + userRightId +
                ", user_type_id=" + user_type_id +
                ", rights='" + rights + '\'' +
                '}';
    }
}
