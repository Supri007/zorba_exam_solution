package org.springExamMVC.Service;

import org.springExamMVC.dao.IUser;
import org.springExamMVC.entity.User;
import org.springExamMVC.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private IUser userDao;

    @Transactional
    public String addUserData(UserModel userModel) {
        String responseMsg = "";
        if (userModel != null ) {
            User user = new User();
            user.setName(userModel.getName());
            user.setEmail(userModel.getEmail());
            user.setMobile(userModel.getMobile());
            user.setUserName(userModel.getUserName());
            user.setPassword(userModel.getPassword());
            responseMsg = this.userDao.addUser(user);
        } else {
            responseMsg = "DB insertion was not successful";
        }
        return responseMsg;
    }
}
