package com.solution.goncharova.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class {@code RegisteredUserRole} in package {@code com.solution.goncharova.entity}
 *
 * Create table users with all attributes in DB
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
@Entity
@Table(name = "`RegisteredUserRole`" , schema = "Book_Store_Hiber")
public class RegisteredUserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registerUserRoleId")
    private int registerUserRoleId;

    @Column(name = "user_id")
    @NotNull
    @Size(max = 1)
    private int user_id;

    @Column(name = "user_type_id")
    @NotNull
    @Size(max = 1)
    private int user_type_id;


//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "user_id")
//    private User user;
//
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "userTypeId")
//    private UserType userType;

    public RegisteredUserRole() {
    }

    public RegisteredUserRole(int registerUserRoleId, int user_id, int user_type_id) {
        this.registerUserRoleId = registerUserRoleId;
        this.user_id = user_id;
        this.user_type_id = user_type_id;
    }


    public int getRegisterUserRoleId() {
        return registerUserRoleId;
    }

    public void setRegisterUserRoleId(int registerUserRoleId) {
        this.registerUserRoleId = registerUserRoleId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(int user_type_id) {
        this.user_type_id = user_type_id;
    }

    @Override
    public String toString() {
        return "RegisteredUserRole{" +
                "registerUserRoleId=" + registerUserRoleId +
                ", user_id=" + user_id +
                ", user_type_id=" + user_type_id +
                '}';
    }
}
