package com.solution.goncharova.services;

import com.solution.goncharova.dao.PurchaseDaoImpl;
import com.solution.goncharova.entity.Purchase;
import java.util.List;

/**
 * Class {@code PurchaseServices} in package {@code com.solution.goncharova.services}
 *
 * It is mediator from PurchaseDaoImpl and Purchase
 * This class use all CRUD methods of DAO
 * We use it in business logic
 *
 * @author Goncharova Anna
 * @version 1.0
 *
 */
public class PurchaseServices {

    private PurchaseDaoImpl purchaseDao = new PurchaseDaoImpl();

    public PurchaseServices() {
    }

    public Purchase findPurchase(int id) {
        return purchaseDao.find(id);
    }

    public void savePurchase(Purchase purchase) {
        purchaseDao.create(purchase);
    }

    public void deletePurchase(Purchase purchase) {
        purchaseDao.delete(purchase);
    }

    public void updatePurchaser(Purchase purchase) {
        purchaseDao.update(purchase);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseDao.findAll();
    }
}
