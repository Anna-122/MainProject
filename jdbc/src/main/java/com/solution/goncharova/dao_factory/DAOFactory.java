package com.solution.goncharova.dao_factory;

import com.solution.goncharova.dao.CityDao;
import com.solution.goncharova.dao.CountriesDao;
import com.solution.goncharova.dao.UsersDao;

/**
 * Class created to production of new copies of the desired object
 */
public  class DAOFactory {
    public static CityDao getCityDao() {

        return new CityDao();
    }

    public  static CountriesDao getCountryDao() {

        return new CountriesDao();
    }

    public static UsersDao getUsersDao() {
        return new UsersDao();
    }
}

//производство новых экземпляров нужного обьекта