package com.solution.goncharova.services;

import com.solution.goncharova.dao.RegisteredUserRoleDaoImpl;
import com.solution.goncharova.entity.RegisteredUserRole;


import java.util.List;


/**
 * Class {@code RegisteredUserRoleServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from RegisteredUserRoleDaoImpl and RegisteredUserRole
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class RegisteredUserRoleServices {

    private RegisteredUserRoleDaoImpl registeredUserRoleDao = new RegisteredUserRoleDaoImpl();

    public RegisteredUserRoleServices() {
    }

    public RegisteredUserRole findRegisteredUserRole(int id) {
        return registeredUserRoleDao.find(id);
    }

    public void saveRegisteredUserRole(RegisteredUserRole registeredUserRole) {
        registeredUserRoleDao.create(registeredUserRole);
    }

    public void deleteRegisteredUserRole(RegisteredUserRole registeredUserRole) {
        registeredUserRoleDao.delete(registeredUserRole);
    }

    public void updateRegisteredUserRole(RegisteredUserRole registeredUserRole) {
        registeredUserRoleDao.update(registeredUserRole);
    }

    public List<RegisteredUserRole> findAllRegisteredUserRoles() {
        return registeredUserRoleDao.findAll();
    }
}
