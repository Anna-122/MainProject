package com.solution.goncharova.services;


import com.solution.goncharova.dao.BookDaoImpl;
import com.solution.goncharova.dao.PublishingHouseDaoImpl;
import com.solution.goncharova.entity.Author;
import com.solution.goncharova.entity.Books;
import com.solution.goncharova.entity.PublishingHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class {@code PublishingHouseServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from PublishingHouseDaoImpl and PublishingHouse
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class PublishingHouseServices  {

    private PublishingHouseDaoImpl publishingHouseDao = new PublishingHouseDaoImpl();

    public PublishingHouseServices() {
    }

    public PublishingHouse findPublishingHouse(int id) {
        return publishingHouseDao.find(id);
    }

    public void savePublishingHouse(PublishingHouse publishingHouse) {
        publishingHouseDao.create(publishingHouse);
    }

    public void deletePublishingHouse(PublishingHouse publishingHouse) {
        publishingHouseDao.delete(publishingHouse);
    }

    public void updatePublishingHouse(PublishingHouse publishingHouse) {
        publishingHouseDao.update(publishingHouse);
    }

    public List<PublishingHouse> findAllPublishingHouses() {
        return publishingHouseDao.findAll();
    }


}
