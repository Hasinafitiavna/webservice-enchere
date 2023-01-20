package com.example.webservice.enchere.entity;

import java.sql.Timestamp;

public class EnchereAction {
    int idenchere;
    int idclient;
    double montant;
    Timestamp dateaction;

    public EnchereAction(){}

    public int getIdenchere() {
        return idenchere;
    }

    public void setIdenchere(int idenchere) {
        this.idenchere = idenchere;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Timestamp getDateaction() {
        return dateaction;
    }

    public void setDateaction(Timestamp dateaction) {
        this.dateaction = dateaction;
    }

    public EnchereAction(int idenchere, int idclient, double montant, Timestamp dateaction) {
        this.idenchere = idenchere;
        this.idclient = idclient;
        this.montant = montant;
        this.dateaction = dateaction;
    }
}
