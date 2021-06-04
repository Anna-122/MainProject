package com.solution.goncharova.dao;

import com.solution.goncharova.entity.Users;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.sql.Connection;

public class UsersDao implements DAO<Users, String> {

    /**
     * Connection of database.
     */
    @NotNull
    private  Connection connection;

    /**
     * Init database connection.
     *
     * @param connection of database.
     */
    public UsersDao(final Connection connection) {
        this.connection = connection;
    }

    public UsersDao() {

    }

    /**
     * Create User in database.
     *
     * @param user for create.
     * @return false if User already exist. If creating success true.
     */

    @Override
    public boolean create( Users user ) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY)) {
            statement.setInt(1,user.getUser_id());
            statement.setString(2,user.getUser_name());
            statement.setString(3,user.getUser_surname());
            statement.setString(4,user.getUser_middle_name());
            statement.setString(5, String.valueOf(user.getUser_sex()));
            statement.setString(6, String.valueOf(user.getUser_email()));
            statement.setString(7, String.valueOf(user.getUser_username()));
            statement.setString(8, String.valueOf(user.getUser_password()));
            statement.setDate(9, (Date) user.getUser_birthday());
            statement.setInt(10,user.getUser_country_id());
            statement.setInt(11,user.getUser_city_id());
            statement.setString(12,user.getUser_street());
            statement.setString(13,user.getUser_street());
            statement.setString(14,user.getUser_street());
            statement.setString(15, String.valueOf(user.getUser_house_number()));
            statement.setString(16, String.valueOf(user.getUser_flat_number()));
            statement.setInt(17,user.getUser_type_id());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Select User by login.
     *
     * @param userName for select.
     * @return return valid entity if she exist. If entity does not exist return empty User with id = -1.
     */
    @Override
    public Users read(@NotNull final String userName) {

        final Users result = new Users();
        result.setUser_id(-1);

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
            statement.setString(1, userName);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setUser_id(Integer.parseInt(rs.getString("id")));
                result.setUser_username(userName);
                result.setUser_password(rs.getString("user_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Update User's password by id.
     *
     * @param user new user's state.
     * @return True if success. False if fail.
     */
    @Override
    public boolean update(@NotNull final Users user ) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.UPDATE.QUERY)) {
            statement.setString(1, String.valueOf(user.getUser_password()));
            statement.setInt(2, user.getUser_id());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



    /**
     * Delete User by id AND login AND password.
     *
     * @param user for delete.
     * @return true if User was deleted. False if User not exist.
     */
    @Override
    public boolean delete(@NotNull final Users user) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setInt(1, user.getUser_id());
            statement.setString(2, user.getUser_username());
            statement.setString(3, String.valueOf(user.getUser_password()));
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * SQL queries for users table.
     */
    enum SQLUser {
        GET("SELECT user_id, user_username, user_password, r.id AS rol_id, r.role FROM users AS u LEFT JOIN roles AS r ON u.role = r.id WHERE u.login = (?)"),
        INSERT("INSERT INTO users (user_id, user_username, user_password) VALUES (DEFAULT, (?), (?), (?)) RETURNING user_id"),
        DELETE("DELETE FROM users WHERE user_id = (1) AND user_username = (1) AND user_password = (1) RETURNING user_id"),
        UPDATE("UPDATE users SET user_password = (23456) WHERE user_id = (2) RETURNING user_id");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}

