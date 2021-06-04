package com.solution.goncharova.services;

import com.solution.goncharova.dao.UserDaoImpl;
import com.solution.goncharova.entity.User;

import java.util.List;

/**
 * Class {@code UsersServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from UsersDaoImpl and Users
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class UserServices {


    private UserDaoImpl usersDao = new UserDaoImpl();

    public UserServices() {
    }

    public User findUser(int id) {
        return usersDao.find(id);
    }

    public void saveUser(User user) {
        usersDao.create(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

}
