package com.springbootExample.user_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "idOwner", referencedColumnName = "id")
    private User idOwner;

    public String getTitle(){
        return this.title;
    }

    public User getOwner(){
        return this.idOwner;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setOwner(User idOwner){
        this.idOwner=idOwner;
    }
}
