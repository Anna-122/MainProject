package com.solution.goncharova.dao;

import com.solution.goncharova.connection.HibernateSessionFactoryUtil;
import com.solution.goncharova.dao.interfaces.DAO;
import com.solution.goncharova.entity.AccessRightsList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccessRightsListDaoImpl implements DAO<AccessRightsList,  Integer> {

    private static final Logger LOG = LogManager.getLogger(AccessRightsListDaoImpl.class);

    @Override
    public void create(AccessRightsList accessRightsList) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.save(accessRightsList);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }

    @Override
    public List<AccessRightsList> findAll() {
        List<AccessRightsList> accessRightsList= (    List<AccessRightsList>)  HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("From AccessRightsList").list();
        return accessRightsList;
    }

    @Override
    public AccessRightsList find(Integer accessRightsListId) {

        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(AccessRightsList.class, accessRightsListId);
    }

    @Override
    public void update(AccessRightsList accessRightsList) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.update(accessRightsList);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }

    @Override
    public void delete(AccessRightsList accessRightsList) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.delete(accessRightsList);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }
}
