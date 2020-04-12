package ua.lviv.home;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static Session session;

    private static Session buildSession() {
        Configuration conf = new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();

        return session;
    }

    public static Session getSession() {
        if (session == null) {
            session = buildSession();
        }
        return session;
    }
}
