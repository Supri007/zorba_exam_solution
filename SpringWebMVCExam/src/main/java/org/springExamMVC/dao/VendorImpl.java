package org.springExamMVC.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springExamMVC.Exception.UserDataException;
import org.springExamMVC.entity.User;

import java.util.List;

public class VendorImpl implements IVendor {

    private SessionFactory sessionFactory;

    public VendorImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public String validateVendor(String username, String password, String role) throws UserDataException {
        String response = "";
        Session session = this.sessionFactory.openSession();
        String validateVendor = "FROM User where name = :username and password = :password and role = :role";
        try {
            Query query = session.createQuery(validateVendor);
            User user = (User) query.uniqueResult();
            if (user != null) {
                response = "Vendor validation successful";
            }
            else{
                throw new UserDataException("Vendor validation failed");
            }
        } catch (Exception e) {
            throw new UserDataException(e.getMessage());
        } finally {
            if (session != null) {
                //session.close();
            }
        }
        return response;
    }
}
