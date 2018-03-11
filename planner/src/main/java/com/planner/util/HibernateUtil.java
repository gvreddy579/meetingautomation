package com.planner.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry standardRegistry;

    static {
        try {

            // File hibernate.cfg.xml should be under the resources folder
            standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        } catch (Throwable th) {
            System.err.println("Initial SessionFactory creation failed" + th);
            if (standardRegistry != null) {
                StandardServiceRegistryBuilder.destroy(standardRegistry);
            }
            throw new ExceptionInInitializerError(th);
        }
    }

    public static SessionFactory getSessionFactory() {

        return sessionFactory;

    }

    public static void shutdown() {
        if (standardRegistry != null) {
            StandardServiceRegistryBuilder.destroy(standardRegistry);
        }
    }

}
