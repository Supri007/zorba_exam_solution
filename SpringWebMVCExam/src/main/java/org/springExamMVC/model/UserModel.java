package org.springExamMVC.model;

import lombok.Data;

@Data
public class UserModel {
    private Integer userId;
    private String name;
    private String email;
    private long mobile;
    private String userName;
    private String password;
    private String role;

}
