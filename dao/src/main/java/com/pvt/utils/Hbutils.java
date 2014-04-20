package com.pvt.utils;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Hbutils {
    private static Hbutils util = null;
    private static Logger log = Logger.getLogger(Hbutils.class);

    private final static ThreadLocal sessions = new ThreadLocal();
    private static ServiceRegistry sr;



        private static SessionFactory sessionFactory;
        private static ServiceRegistry serviceRegistry;

        private static SessionFactory configureSessionFactory() throws HibernateException {
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }

        public static SessionFactory getSessionFactory() {
            return configureSessionFactory();

        }
    }