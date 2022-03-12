package uz.ixtiyor21.trello_magic.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory sessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
            sessionFactory = metadata.buildSessionFactory();
        }
        return sessionFactory;
    }
}
