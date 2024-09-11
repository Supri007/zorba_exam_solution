package org.springExamMVC.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springExamMVC.Exception.UserDataException;
import org.springExamMVC.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUser{

    private SessionFactory sessionFactory;

    public UserImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        String message = "";
        //Transaction tx = null;
        try {
            //tx = session.beginTransaction();
            session.persist(user);
            //tx.commit();
            message = "User added successfully";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            //tx.rollback();
            message = "DB action was not successful";
        } finally {
            if (session != null) {
                //session.close();
            }
        }
        return message;
    }

    @Override
    public List<User> getAllUsers() throws UserDataException {
        List<User> users = new ArrayList<>();
        Session session = this.sessionFactory.openSession();
        String userFromDB = "FROM User";
        try {
            Query query = session.createQuery(userFromDB);
            users = query.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new UserDataException("Error while fetching data: " + e.getMessage());
        } finally {
            if (session != null) {
                //session.close();
            }
        }
        return users;
    }

    @Override
    public User getUserById(Integer userId) throws UserDataException {
        Session session = this.sessionFactory.getCurrentSession();
        User user = null;
        String userFromDB = "FROM User where id = " + userId;
        try {
            Query query = session.createQuery(userFromDB);
            user = (User)query.uniqueResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new UserDataException("Error while fetching data: " + e.getMessage());
        } finally {
            if (session != null) {
                //session.close();
            }
        }
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<User> updateUserRole(User user) throws UserDataException {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> users = new ArrayList<>();
        User userToUpdate = getUserById(user.getUserId());
        String role = userToUpdate.getRole();
        if (role != null) {
            userToUpdate.setRole((user.getRole()) + "," + role);
        }
        else{
            userToUpdate.setRole(user.getRole());
        }

        try {
            session.saveOrUpdate(userToUpdate);
            users = getAllUsers();
        } catch (Exception e) {
            throw new UserDataException("Failed to update user. Error: " + e.getMessage());
        } finally {
            if (session != null) {
                //session.close();
            }
        }
        return users;
    }
}
