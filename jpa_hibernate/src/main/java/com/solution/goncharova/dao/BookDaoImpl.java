package com.solution.goncharova.dao;

import com.solution.goncharova.connection.HibernateSessionFactoryUtil;
import com.solution.goncharova.dao.interfaces.DAO;
import com.solution.goncharova.entity.Books;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

/**
 * Class {@code BooksDaoImpl} in package {@code com.solution.goncharova.dao}
 *
 * Implementation of BooksDao interface, where we have realization of CRUD components
 *
 * @author Goncharova Anna
 * @version 1.0
 */
public class BookDaoImpl implements DAO<Books, Integer> {

    private static final Logger LOG = LogManager.getLogger(BookDaoImpl.class);

    @Override
    public void create(Books book) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.save(book);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }

    @Override
    public List<Books> findAll() {
        List<Books> books = (List<Books>)  HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("From Books").list();
        return books;
    }

    @Override
    public Books find(Integer bookId) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().get(Books.class, bookId);
    }

    @Override
    public void update(Books book) {
        Transaction tx1 = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            tx1 = session.beginTransaction();
            session.update(book);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }

    @Override
    public void delete(Books book) {
        Transaction tx1 = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            tx1 = session.beginTransaction();
            session.delete(book);
            tx1.commit();
        } catch (Exception e) {
            LOG.info("\n Exception. Rolling back transaction. Logging and continuing.\n", e);
            if (tx1 != null) {
                tx1.rollback();
            }
        }
    }
}