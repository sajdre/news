package com.pvt.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Locale;

public class Hbutils {

        private static SessionFactory sessionFactory = null;
        private static ServiceRegistry serviceRegistry;

        public static SessionFactory getSessionFactory() {
            if(sessionFactory == null){
                Locale.setDefault(Locale.ENGLISH);
                Configuration configuration = new Configuration();
                configuration.configure();
                serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            return sessionFactory;
        }
    }