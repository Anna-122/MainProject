package com.solution.goncharova.dao;

import com.solution.goncharova.connection.HibernateSessionFactoryUtil;
import com.solution.goncharova.dao.interfaces.DAO;
import com.solution.goncharova.entity.Books;
import com.solution.goncharova.entity.RegisteredUserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegisteredUserRoleDaoImpl implements DAO <RegisteredUserRole, Integer> {

    private static final Logger LOG = LogManager.getLogger(RegisteredUserRoleDaoImpl.class);


    @Override
    public void create(RegisteredUserRole registeredUserRole) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.save(registeredUserRole);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }

    }

    @Override
    public List<RegisteredUserRole> findAll() {
        List<RegisteredUserRole> registeredUserRole = (List<RegisteredUserRole>)  HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("From RegisteredUserRole").list();
        return registeredUserRole;
    }

    @Override
    public RegisteredUserRole find(Integer registeredUserRoleId) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(RegisteredUserRole.class, registeredUserRoleId);
    }

    @Override
    public void update(RegisteredUserRole registeredUserRole) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.update(registeredUserRole);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }

    @Override
    public void delete(RegisteredUserRole registeredUserRole) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.delete(registeredUserRole);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }
}
