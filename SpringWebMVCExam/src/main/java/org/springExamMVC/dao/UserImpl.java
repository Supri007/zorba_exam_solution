package org.springExamMVC.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springExamMVC.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserImpl implements IUser{

    private SessionFactory sessionFactory;

    public UserImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String addUser(User user) {
        Session session = this.sessionFactory.openSession();
        String message = "";
        try {
            session.persist(user);
            message = "User added successfully";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            message = "DB action was not successful";
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return message;
    }
}
