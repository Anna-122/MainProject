package com.solution.goncharova.dao;

import com.solution.goncharova.connection.HibernateSessionFactoryUtil;
import com.solution.goncharova.dao.interfaces.DAO;
import com.solution.goncharova.entity.Books;
import com.solution.goncharova.entity.Storage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StorageDaoImpl implements DAO<Storage,Integer> {

    private static final Logger LOG = LogManager.getLogger(StorageDaoImpl.class);


    @Override
    public void create(Storage storage) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.save(storage);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }

    @Override
    public List<Storage> findAll() {
        List<Storage> storage = (List<Storage>)  HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("From Storage").list();
        return storage;
    }

    @Override
    public Storage find(Integer storageId) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(Storage.class, storageId);
    }

    @Override
    public void update(Storage storage) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.update(storage);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }

    @Override
    public void delete(Storage storage) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.delete(storage);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }
}
