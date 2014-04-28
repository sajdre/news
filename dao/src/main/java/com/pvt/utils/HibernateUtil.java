package com.pvt.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Locale;

public class HibernateUtil {
        private HibernateUtil(){
        }
        private static SessionFactory sessionFactory = null;
        private static ServiceRegistry serviceRegistry;

        public static SessionFactory getSessionFactory() {
            if(sessionFactory == null){
                Locale.setDefault(Locale.ENGLISH);
                Configuration configuration = new Configuration();
                configuration.configure();
                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            return sessionFactory;
        }
    }