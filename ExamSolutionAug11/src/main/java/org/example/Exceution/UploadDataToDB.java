package org.example.Exceution;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UploadDataToDB {

    public static void UploadData(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Create SessionFactory Object from Configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Create new Session
        Session session = sessionFactory.openSession();
        Transaction tx = null;
    }
}
