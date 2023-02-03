package com.example.webservice.enchere.entity;

import java.sql.Timestamp;

public class Enchere {
    int id;
    int idproduit;
    int idclientdetenteur;
    Timestamp datedebut;
    Timestamp datefin;
    double montantdebase;
    boolean state;

    public Enchere(int id, int idproduit, int idclientdetenteur, Timestamp datedebut, Timestamp datefin, double montantdebase, boolean state) {
        this.id = id;
        this.idproduit = idproduit;
        this.idclientdetenteur = idclientdetenteur;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.montantdebase = montantdebase;
        this.state = state;
    }

    public Enchere(int id, int idproduit, Timestamp datedebut, Timestamp datefin, double montantdebase) {
        this.id = id;
        this.idproduit = idproduit;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.montantdebase = montantdebase;
    }

    public Enchere(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getIdclientdetenteur() {
        return idclientdetenteur;
    }

    public void setIdclientdetenteur(int idclientdetenteur) {
        this.idclientdetenteur = idclientdetenteur;
    }

    public Timestamp getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Timestamp datedebut) {
        this.datedebut = datedebut;
    }

    public Timestamp getDatefin() {
        return datefin;
    }

    public void setDatefin(Timestamp datefin) {
        this.datefin = datefin;
    }

    public double getMontantdebase() {
        return montantdebase;
    }

    public void setMontantdebase(double montantdebase) {
        this.montantdebase = montantdebase;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
