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

    public String getVia(){
            return this.via;
        }

    public String getPrezzo(){
            return this.prezzo;
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
}
