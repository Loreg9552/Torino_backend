package com.springbootExample.user_api.model;

import jakarta.persistence.*;
@Entity
@Table(name = "immobili")
public class Immobili {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String via;
    private String prezzo;
    private String mq;
    @ManyToOne
    @JoinColumn(name = "idOwner", referencedColumnName = "id")
    private User idOwner;

    public String getVia(){
            return this.via;
        }

    public String getPrezzo(){
            return this.prezzo;
        }

    public User getOwner(){
        return this.idOwner;
    }

    public void setVia(String via){
            this.via=via;
        }

    public void setPrezzo(String prezzo){
            this.prezzo=prezzo;
        }

    public String getMq(){
            return this.mq;
        }

    public void setMq(String mq){ this.mq=mq;}

    public void setOwner(User idOwner){
        this.idOwner=idOwner;
    }
}
