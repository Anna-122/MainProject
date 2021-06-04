package com.solution.goncharova.services;

import com.solution.goncharova.dao.UserTypeDaoImpl;
import com.solution.goncharova.entity.UserType;

import java.util.List;

/**
 * Class {@code UserTypeServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from UserTypeDaoImpl and UserType
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class UserTypeServices {
    private UserTypeDaoImpl userTypeDao = new UserTypeDaoImpl();

    public UserTypeServices() {
    }

    public UserType findUserType(int id) {
        return userTypeDao.find(id);
    }

    public void saveUserType(UserType userType) {
        userTypeDao.create(userType);
    }

    public void deleteUserType(UserType userType) {
        userTypeDao.delete(userType);
    }

    public void updateUserType(UserType userType) {
        userTypeDao.update(userType);
    }

    public List<UserType> findAllUserTypes() {
        return userTypeDao.findAll();
    }
}
