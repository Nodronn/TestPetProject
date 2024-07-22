package com.example.SpringTestProject.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name = "users") //временно. потом поменять
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Password", nullable = false)
    private String password;
    //private String repeatPassword;
    @Column(name = "Country")
    private String country;

    @Enumerated(value = EnumType.STRING)
    private Role userRole;


}
