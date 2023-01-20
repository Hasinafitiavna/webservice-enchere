package com.example.webservice.enchere.entity;

public class Admin {
    int id;
    String nom;
    String pass;

    public Admin(){}

    public Admin(int id, String nom, String pass) {
        this.id = id;
        this.nom = nom;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
