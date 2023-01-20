package com.example.webservice.enchere.entity;

public class Produit {
    int id;
    String nom;
    String lienimage;

    public Produit(){}

    public Produit(String nom, String lienimage) {
        this.nom = nom;
        this.lienimage = lienimage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLienimage() {
        return lienimage;
    }

    public void setLienimage(String lienimage) {
        this.lienimage = lienimage;
    }
}
