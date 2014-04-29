package com.pvt.daoConfiguration;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Locale;

public class HibernateUtil {
    private HibernateUtil(){
        }
    private static SessionFactory sessionFactory = null;



    public static SessionFactory getSessionFactory() {
            if(sessionFactory == null){
                Logger log = Logger.getLogger(HibernateUtil.class);
                try{
                Locale.setDefault(Locale.ENGLISH);
                Configuration configuration = new Configuration();
                configuration.configure();
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                }catch(Exception rex){

                     log.info("Can`t create session factory", rex);
                }
            }
            return sessionFactory;
        }
    }