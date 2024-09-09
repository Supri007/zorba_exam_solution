package org.springExamMVC.dao;

import org.springExamMVC.Exception.UserDataException;
import org.springExamMVC.entity.User;

public interface IVendor {
    public String validateVendor(String username, String password, String role) throws UserDataException;
}
