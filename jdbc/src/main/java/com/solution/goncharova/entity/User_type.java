package com.solution.goncharova.entity;

public class User_type {

    private int user_type_id;
    private  String user_type;

    public User_type() {
        this.user_type_id = user_type_id;
        this.user_type = user_type;
    }

    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id( int user_type_id ) {
        this.user_type_id = user_type_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type( String user_type ) {
        this.user_type = user_type;
    }

    @Override
    public String toString() {
        return "User_type{" +
                "user_type_id=" + user_type_id +
                ", user_type='" + user_type + '\'' +
                '}';
    }
}
