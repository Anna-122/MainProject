package com.solution.goncharova.connection;

import com.solution.goncharova.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Class {@code HibernateSessionFactoryUtil} in package {@code com.solution.goncharova.connection}
 *
 * Create session factory, configure our classes and build it
 *
 * @author Goncharova Anna
 * @version 1.0
 */
public class HibernateSessionFactoryUtil {
    private static final Logger LOG = LogManager.getLogger(HibernateSessionFactoryUtil.class);

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Countries.class);
                configuration.addAnnotatedClass(Cities.class);
                configuration.addAnnotatedClass(PublishingHouse.class);
                configuration.addAnnotatedClass(Author.class);
                configuration.addAnnotatedClass(Books.class);
                configuration.addAnnotatedClass(Storage.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Purchase.class);
                configuration.addAnnotatedClass(AccessRightsList.class);
                configuration.addAnnotatedClass(UserType.class);
                configuration.addAnnotatedClass(RegisteredUserRole.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                LOG.info("\nException with connect to DB " + e);
            }
        }
        return sessionFactory;
    }
}

