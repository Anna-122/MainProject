package com.solution.goncharova.dao;

import com.solution.goncharova.connection.HibernateSessionFactoryUtil;
import com.solution.goncharova.dao.interfaces.DAO;
import com.solution.goncharova.entity.Books;
import com.solution.goncharova.entity.UserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserTypeDaoImpl implements DAO <UserType,Integer> {

    private static final Logger LOG = LogManager.getLogger(UserTypeDaoImpl.class);

    @Override
    public void create(UserType userType) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.save(userType);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }

    }

    @Override
    public List<UserType> findAll() {
        List<UserType> userType = (List<UserType>)  HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("From UserType").list();
        return userType;
    }

    @Override
    public UserType find(Integer userTypeId) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(UserType.class, userTypeId);
    }

    @Override
    public void update(UserType userType) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.update(userType);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }

    @Override
    public void delete(UserType userType) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.delete(userType);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }

    }
}
