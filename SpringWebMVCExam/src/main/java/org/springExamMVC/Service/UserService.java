package org.springExamMVC.Service;

import org.springExamMVC.Exception.UserDataException;
import org.springExamMVC.dao.IUser;
import org.springExamMVC.entity.User;
import org.springExamMVC.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUser userDao;

    @Transactional
    public String addUserData(UserModel userModel) throws UserDataException {
        String responseMsg = "";
        if (userModel != null ) {
            try{
                User user = new User();
                user.setName(userModel.getName());
                if (userModel.getEmail().contains("@")){
                    user.setEmail(userModel.getEmail());
                }
                else{
                    throw new UserDataException("User Email provided is not correct");
                }
                String userMob = Long.toString(userModel.getMobile());
                if (userMob.length() <= 10){
                    user.setMobile(userModel.getMobile());
                }
                else{
                    throw new UserDataException("User Mobile provided is not correct");
                }
                user.setUserName(userModel.getUserName());
                if (userModel.getPassword().length() >= 8){
                    user.setPassword(userModel.getPassword());
                }
                else{
                    throw new UserDataException("User Password should be at least 8 characters. " +
                            "Password length provided: " + userModel.getPassword().length());
                }
                responseMsg = this.userDao.addUser(user);
            }
            catch(Exception e){
                throw new UserDataException("User Input data error received: " + e.getMessage());
            }

        } else {
            responseMsg = "DB insertion was not successful";
        }
        return responseMsg;
    }

    public List<UserModel> getAllUsersData() throws UserDataException {
        List<User> getUsers = this.userDao.getAllUsers();
        List<UserModel> userModels = new ArrayList<>();
        for (User user : getUsers) {
            UserModel userModel = new UserModel();
            userModel.setUserId(user.getUserId());
            userModel.setName(user.getName());
            userModel.setUserName(user.getUserName());
            userModel.setEmail(user.getEmail());
            userModel.setMobile(user.getMobile());
            userModel.setPassword(user.getPassword());
            userModels.add(userModel);
        }
        return userModels;
    }

    public List<UserModel> updateUserRole(int userId, String role) throws UserDataException {

        List<UserModel> userModels = new ArrayList<>();
        try{
            User user = new User();
            user.setUserId(userId);
            user.setRole(role);
            List<User> users = this.userDao.updateUserRole(user);

            for (User user1 : users) {
                UserModel userModel = new UserModel();
                userModel.setUserId(user1.getUserId());
                userModel.setName(user1.getName());
                userModel.setUserName(user1.getUserName());
                userModel.setEmail(user1.getEmail());
                userModel.setMobile(user1.getMobile());
                userModel.setPassword(user1.getPassword());
                userModel.setRole(user1.getRole()
                );
                userModels.add(userModel);
            }
        }
        catch(Exception e){
            throw new UserDataException("Updating user role was not successful. Error: " + e.getMessage());
        }
        return userModels;
    }
}
