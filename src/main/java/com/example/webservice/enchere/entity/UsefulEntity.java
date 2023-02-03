package com.example.webservice.enchere.entity;

public class UsefulEntity {
    int idclient;
    boolean state;
    String message;

    public UsefulEntity(){}

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UsefulEntity(int idclient, boolean state) {
        this.idclient = idclient;
        this.state = state;
    }
}
