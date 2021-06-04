package com.solution.goncharova.services;

import com.solution.goncharova.dao.AccessRightsListDaoImpl;
import com.solution.goncharova.entity.AccessRightsList;
import java.util.List;


/**
 * Class {@code AccessRightsListServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from AccessRightsListDaoImpl and AccessRightsList
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class AccessRightsListServices {

    private AccessRightsListDaoImpl accessRightsListDao = new AccessRightsListDaoImpl();

    public AccessRightsListServices() {
    }

    public AccessRightsList findAccessRightsList(int id) {
        return accessRightsListDao.find(id);
    }

    public void saveAccessRightsList(AccessRightsList accessRightsList) {
        accessRightsListDao.create(accessRightsList);
    }

    public void deleteAccessRightsList(AccessRightsList accessRightsList) {
        accessRightsListDao.delete(accessRightsList);
    }

    public void updateAccessRightsList(AccessRightsList accessRightsList) {
        accessRightsListDao.update(accessRightsList);
    }

    public List<AccessRightsList> findAllAccessRightsLists() {
        return accessRightsListDao.findAll();
    }
}
