package com.example.webservice.enchere;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConn() throws Exception{
        String url="jdbc:postgresql://containers-us-west-150.railway.app:8041/railway";
        String user="postgres";
        String pass="MRSBzgoeDvZgCCqSqEE4";
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
}
