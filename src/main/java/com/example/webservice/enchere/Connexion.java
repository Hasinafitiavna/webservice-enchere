package com.example.webservice.enchere;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConn() throws Exception{
        String url="jdbc:postgresql://localhost:5432/enchere";
        String user="postgres";
        String pass="hasina";
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
}
