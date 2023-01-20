package com.example.webservice.enchere.entity;

public class Enchere {
    int id;
    int idproduit;
    int idclientdetenteur;
    String dateDebut;
    String dateFin;
    int montantBase;

    public Enchere(int id, int idproduit, int idclientdetenteur, String dateDebut, String dateFin, int montantBase) {
        this.id = id;
        this.idproduit = idproduit;
        this.idclientdetenteur = idclientdetenteur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montantBase = montantBase;
    }

    public Enchere(int id, int idproduit, String dateDebut, String dateFin, int montantBase) {
        this.id = id;
        this.idproduit = idproduit;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montantBase = montantBase;
    }

    public Enchere() {
    }

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

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getMontantBase() {
        return montantBase;
    }

    public void setMontantBase(int montantBase) {
        this.montantBase = montantBase;
    }
}
