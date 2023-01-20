package com.example.webservice.enchere.entity;

public class Statistique {
    double maxenchere;
    int mostwinningclient;
    double totalbenefice;

    public Statistique(){}

    public double getMaxenchere() {
        return maxenchere;
    }

    public void setMaxenchere(double maxenchere) {
        this.maxenchere = maxenchere;
    }

    public int getMostwinningclient() {
        return mostwinningclient;
    }

    public void setMostwinningclient(int mostwinningclient) {
        this.mostwinningclient = mostwinningclient;
    }

    public double getTotalbenefice() {
        return totalbenefice;
    }

    public void setTotalbenefice(double totalbenefice) {
        this.totalbenefice = totalbenefice;
    }

    public Statistique(int maxenchere, int mostwinningclient, double totalbenefice) {
        this.maxenchere = maxenchere;
        this.mostwinningclient = mostwinningclient;
        this.totalbenefice = totalbenefice;
    }
}