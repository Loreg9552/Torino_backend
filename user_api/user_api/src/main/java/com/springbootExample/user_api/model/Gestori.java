package com.springbootExample.user_api.model;

import jakarta.persistence.*;
@Entity
@Table(name = "gestori")
public class Gestori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    public Long getId(){
        return this.id;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setPassword(String password){
        this.password= password;
    }
}
