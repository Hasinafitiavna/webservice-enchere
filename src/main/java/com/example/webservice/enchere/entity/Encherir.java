package com.example.webservice.enchere.entity;

import java.sql.Timestamp;

public class Encherir {
    int id;
    int idclient;
    int montant;
    Timestamp dateaction;

    public Timestamp getDateaction() {
        return dateaction;
    }

    public void setDateaction(Timestamp dateaction) {
        this.dateaction = dateaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

}
