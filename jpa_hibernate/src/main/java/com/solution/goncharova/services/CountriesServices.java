package com.solution.goncharova.services;

import com.solution.goncharova.dao.CountriesDaoImpl;
import com.solution.goncharova.dao.UserDaoImpl;
import com.solution.goncharova.entity.Countries;
import com.solution.goncharova.entity.User;

import java.util.List;

/**
 * Class {@code CountriesServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from CountriesDaoImpl and Countries
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class CountriesServices {


    private CountriesDaoImpl countryDao = new CountriesDaoImpl();

    public CountriesServices() {
    }

    public Countries findCountry(int id) {
        return countryDao.find(id);
    }

    public void saveCountry(Countries country) {
        countryDao.create(country);
    }

    public void deleteCountry(Countries country) {
        countryDao.delete(country);
    }

    public void updateCountry(Countries country) {
        countryDao.update(country);
    }

    public List<Countries> findAllCountries() {
        return countryDao.findAll();
    }
}
