package com.solution.goncharova.dao;

import com.solution.goncharova.connection.HibernateSessionFactoryUtil;
import com.solution.goncharova.dao.interfaces.DAO;

import com.solution.goncharova.entity.Books;
import com.solution.goncharova.entity.Purchase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PurchaseDaoImpl implements DAO<Purchase, Integer> {

    private static final Logger LOG = LogManager.getLogger(PurchaseDaoImpl.class);


    @Override
    public void create(Purchase purchase) {

    }

    @Override
    public List<Purchase> findAll() {
        List<Purchase> purchase = (List<Purchase>)  HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("From Purchase").list();
        return purchase;
    }

    @Override
    public Purchase find(Integer purchaseId) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(Purchase.class, purchaseId);
    }

    @Override
    public void update(Purchase purchase) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.update(purchase);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }

    }

    @Override
    public void delete(Purchase purchase) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.delete(purchase);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }

}
