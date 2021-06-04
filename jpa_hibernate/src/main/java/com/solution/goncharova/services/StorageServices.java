package com.solution.goncharova.services;

import com.solution.goncharova.dao.StorageDaoImpl;
import com.solution.goncharova.entity.Storage;

import java.util.List;

/**
 * Class {@code StorageServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from StorageDaoImpl and Storage
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class StorageServices {

    private StorageDaoImpl storageDao = new StorageDaoImpl();

    public StorageServices() {
    }

    public Storage findStorage(int id) {
        return storageDao.find(id);
    }

    public void saveStorage(Storage storage) {
        storageDao.create(storage);
    }

    public void deleteStorage(Storage storage) {
        storageDao.delete(storage);
    }

    public void updateStorage(Storage storage) {
        storageDao.update(storage);
    }

    public List<Storage> findAllStorages() {
        return storageDao.findAll();
    }
}
