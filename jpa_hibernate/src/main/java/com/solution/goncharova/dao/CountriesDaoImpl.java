package com.solution.goncharova.dao;

import com.solution.goncharova.connection.HibernateSessionFactoryUtil;
import com.solution.goncharova.dao.interfaces.DAO;
import com.solution.goncharova.entity.Countries;
import com.solution.goncharova.entity.Cities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CountriesDaoImpl implements DAO<Countries, Integer> {

    private static final Logger LOG = LogManager.getLogger(CitiesDaoImpl.class);


    @Override
    public void create(Countries country) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.save(country);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            } }

    }

    @Override
    public List<Countries> findAll() {
        List<Countries> country = (List<Countries>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("From Countries").list();
        return country;
    }

    @Override
    public Countries find(Integer country_id) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(Countries.class, country_id);
    }

    @Override
    public void update(Countries country) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.update(country);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }

    }

    @Override
    public void delete(Countries country) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.delete(country);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }
}
