package org.springExamMVC.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private Integer userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_mobile")
    private long mobile;
    @Column(name = "user_username")
    private String userName;
    @Column(name = "user_password")
    private String password;
    @Column(name= "user_role")
    private String role;
}
