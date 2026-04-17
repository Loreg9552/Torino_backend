package com.springbootExample.user_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String job;

    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getJob(){
        return this.job;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setJob(String job){
        this.job= job;
    }
}
