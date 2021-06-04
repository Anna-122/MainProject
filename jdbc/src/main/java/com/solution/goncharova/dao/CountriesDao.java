package com.solution.goncharova.dao;

import com.solution.goncharova.entity.Countries;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountriesDao implements DAO<Countries, String>{
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
    public CountriesDao(@NotNull final Connection connection) {
        this.connection = connection;
    }

    public CountriesDao() {

    }


    @Override
    public boolean create( Countries countries ) {
        return false;
    }

    /**
     * Select Countries by name.
     *
     * @param name for select.
     * @return return valid entity if she exist. If entity does not exist return empty PhoneModel with id = -1.
     */
    @Override
    public Countries read(@NotNull final String name) {

        final Countries result = new Countries();
        result.setCountry(name);

        try (PreparedStatement statement = connection.prepareStatement(CountriesSQL.GET.QUERY)) {

            statement.setString(1, name);

            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setCountry_id(Integer.parseInt(rs.getString("id")));
            } else {
                result.setCountry("entity not exist in Countries");
                result.setCountry_id(-1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Update Countries name by id.
     *
     * @param countries with selected id.
     * @return updated entity.
     */
    @Override
    public boolean update(@NotNull final Countries countries) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(CountriesSQL.UPDATE.QUERY)) {
            statement.setString(1, countries.getCountry());
            statement.setInt(2, countries.getCountry_id());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Delete Countries by name.
     *
     * @param countries for delete.
     * @return true if PhoneModel was deleted. False if PhoneModel not exist.
     */
    @Override
    public boolean delete(@NotNull final Countries countries) {
        if (!isExist(countries.getCountry())) return false;

        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(CountriesSQL.DELETE.QUERY)) {
            statement.setString(1, countries.getCountry());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * SQL queries for Countries table.
     */
    enum CountriesSQL {
        GET("SELECT id FROM Countries WHERE name = (Japan)"),
        DELETE("DELETE FROM Countries WHERE country_name = Japan RETURNING country_id"),
        // ADD("INSERT INTO Countries (country_id, country_name) VALUES (DEFAULT, (?)) RETURNING country_id;"),
        UPDATE("UPDATE Countries SET country_name = (Ukraine) WHERE country_id = (1) RETURNING country_id");

        String QUERY;

        CountriesSQL(String QUERY) {
            this.QUERY = QUERY;
        }
    }

    /**
     * Check exist Countries by name.
     *
     * @param name for select.
     * @return true if exist. False if does not exist.
     */
    private boolean isExist(@NotNull final String name) {
        return read(name).getCountry_id() != -1;
    }
}

