package com.solution.goncharova.services;

import com.solution.goncharova.dao.CitiesDaoImpl;
import com.solution.goncharova.entity.Cities;
import java.util.List;

/**
 * Class {@code CitiesServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from CitiesDaoImpl and Cities
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class CitiesServices {
    private CitiesDaoImpl cityDao = new CitiesDaoImpl();

    public CitiesServices() {
    }

    public Cities findCity(int id) {
        return cityDao.find(id);
    }

    public void saveCity(Cities city) {
        cityDao.create(city);
    }

    public void deleteCity(Cities city) {
        cityDao.delete(city);
    }

    public void updateCity(Cities city) {
        cityDao.update(city);
    }

    public List<Cities> findAllCities() {
        return cityDao.findAll();
    }
}

