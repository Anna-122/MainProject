package com.solution.goncharova.dao;

import com.solution.goncharova.connection.HibernateSessionFactoryUtil;
import com.solution.goncharova.dao.interfaces.DAO;
import com.solution.goncharova.entity.Books;
import com.solution.goncharova.entity.PublishingHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PublishingHouseDaoImpl implements DAO<PublishingHouse, Integer> {

    private static final Logger LOG = LogManager.getLogger(PublishingHouseDaoImpl.class);

    @Override
    public void create(PublishingHouse publishingHouse) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.save(publishingHouse);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }

    }

    @Override
    public List<PublishingHouse> findAll() {
        List<PublishingHouse> publishingHouse = (List<PublishingHouse>)  HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("From PublishingHouse").list();
        return publishingHouse;
    }

    @Override
    public PublishingHouse find(Integer publishingHouseId) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(PublishingHouse.class, publishingHouseId);
    }

    @Override
    public void update(PublishingHouse publishingHouse) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.update(publishingHouse);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }

    }

    @Override
    public void delete(PublishingHouse publishingHouse) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.delete(publishingHouse);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }
 }

