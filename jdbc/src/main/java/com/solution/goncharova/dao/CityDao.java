package com.solution.goncharova.dao;

import com.solution.goncharova.entity.Cities;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CityDao implements DAO<Cities, String> {
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
    public CityDao(@NotNull final Connection connection) {
        this.connection = connection;
    }

    public CityDao() {

    }


    @Override
    public boolean create( Cities cities) {
        return false;
    }

    /**
     * Select Countries by name.
     *
     * @param name for select.
     * @return return valid entity if she exist. If entity does not exist return empty PhoneModel with id = -1.
     */
    @Override
    public Cities read(@NotNull final String name) {

        final Cities result = new Cities();
        result.setCity(name);

        try (PreparedStatement statement = connection.prepareStatement(CountriesDao.CountriesSQL.GET.QUERY)) {

            statement.setString(1, name);

            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result.setCity_id(Integer.parseInt(rs.getString("id")));
            } else {
                result.setCity("entity not exist in Countries");
                result.setCity_id(-1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Update Countries name by id.
     *
     * @param cities with selected id.
     * @return updated entity.
     */
    @Override
    public boolean update(@NotNull final Cities cities) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(CountriesDao.CountriesSQL.UPDATE.QUERY)) {
            statement.setString(1, cities.getCity());
            statement.setInt(2, cities.getCity_id());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Delete Cities by name.
     *
     * @param cities for delete.
     * @return true if Cities was deleted. False if Cities not exist.
     */
    @Override
    public boolean delete(@NotNull final Cities cities) {
        if (!isExist(cities.getCity())) return false;

        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(CountriesDao.CountriesSQL.DELETE.QUERY)) {
            statement.setString(1, cities.getCity());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * SQL queries for Cities table.
     */
    enum CountriesSQL {
        GET("SELECT city_id FROM Cities WHERE name = (Tokyo)"),
        DELETE("DELETE FROM Cities WHERE city_name = Tokyo RETURNING city_id"),
        UPDATE("UPDATE Cities SET city_name = (Kharkov) WHERE city_id = (1) RETURNING city_id");

        String QUERY;

        CountriesSQL(String QUERY) {
            this.QUERY = QUERY;
        }
    }

    /**
     * Check exist Cities by name.
     *
     * @param name for select.
     * @return true if exist. False if does not exist.
     */
    private boolean isExist(@NotNull final String name) {
        return read(name).getCity_id() != -1;
    }
}

