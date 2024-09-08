package org.springExamMVC.dao;

import org.springExamMVC.Exception.UserDataException;
import org.springExamMVC.entity.User;

import java.util.List;

public interface IUser {
    String addUser(User user);
    public List<User> getAllUsers() throws UserDataException;
    public List<User> updateUserRole(User user) throws UserDataException;
}
