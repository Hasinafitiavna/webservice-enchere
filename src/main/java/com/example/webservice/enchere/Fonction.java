package com.example.webservice.enchere;

import com.example.webservice.enchere.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Fonction {
    static Connexion connexion = new Connexion();
    public static ArrayList<Client> getAllClient() throws Exception{
        String sql = "select * from client";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Client> clients = new ArrayList<>();
        while(rs.next()){
            Client cl = new Client();
            cl.setId(rs.getInt("id"));
            cl.setNom(rs.getString("nom"));
            cl.setPass(rs.getString("pass"));
            clients.add(cl);
        }
        connection.close();
        return clients;
    }
    public static ArrayList<ListeEnchere> getAllEnchere() throws Exception{
        String sql = "select * from listeenchere order by id";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<ListeEnchere> clients = new ArrayList<>();
        while(rs.next()){
            ListeEnchere listeEnchere = new ListeEnchere();
            listeEnchere.setId(rs.getInt("id"));
            listeEnchere.setImage(rs.getString("image"));
            listeEnchere.setNomproduit(rs.getString("nomproduit"));
            listeEnchere.setNomclient(rs.getString("nomclient"));
            listeEnchere.setDateDebut(rs.getString("datedebut"));
            listeEnchere.setDateFin(rs.getString("datefin"));
            listeEnchere.setMontantBase(rs.getInt("montantdebase"));
            clients.add(listeEnchere);
        }
        connection.close();
        return clients;
    }
    public static ArrayList<RechargementCompte> getAllRechargement() throws Exception{
        String sql = "select * from rechargementcompte where valid=false";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<RechargementCompte> clients = new ArrayList<>();
        while(rs.next()){
            RechargementCompte rechargementCompte = new RechargementCompte();
            rechargementCompte.setId(rs.getInt("id"));
            rechargementCompte.setIdclient(rs.getInt("idclient"));
            rechargementCompte.setMontant(rs.getDouble("montant"));
            rechargementCompte.setValid(rs.getBoolean("valid"));
            clients.add(rechargementCompte);
        }
        connection.close();
        return clients;
    }
    public static ListeEnchere getEnchere(int id) throws Exception{
        String sql = "select * from listeenchere where id="+id+" order by id";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ListeEnchere listeEnchere = null;
        while(rs.next()){
            listeEnchere = new ListeEnchere();
            listeEnchere.setId(rs.getInt("id"));
            listeEnchere.setNomproduit(rs.getString("nomproduit"));
            listeEnchere.setNomclient(rs.getString("nomclient"));
            listeEnchere.setDateDebut(rs.getString("datedebut"));
            listeEnchere.setDateFin(rs.getString("datefin"));
            listeEnchere.setMontantBase(rs.getInt("montantdebase"));
        }
        connection.close();
        return listeEnchere;
    }
    public static Enchere getEncherebyId(int id) throws Exception{
        String sql = "select * from enchere where id="+id;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Enchere listeEnchere = null;
        while(rs.next()){
            listeEnchere = new Enchere();
            listeEnchere.setId(rs.getInt("id"));
            listeEnchere.setIdproduit(rs.getInt("idproduit"));
            listeEnchere.setIdclientdetenteur(rs.getInt("idclientdetenteur"));
            listeEnchere.setDatedebut(rs.getTimestamp("datedebut"));
            listeEnchere.setDatefin(rs.getTimestamp("datefin"));
            listeEnchere.setMontantdebase(rs.getInt("montantdebase"));
        }
        connection.close();
        return listeEnchere;
    }
    public Client getClientById(int idclient) throws Exception{
        String sql = "select * from client where id="+idclient;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Client cl = new Client();
        while(rs.next()){
            cl.setId(rs.getInt("id"));
            cl.setNom(rs.getString("nom"));
            cl.setPass(rs.getString("pass"));
        }
        connection.close();
        return cl;
    }
    public ArrayList<Produit> getProduit() throws Exception{
        String sql = "select * from produit order by id";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);


        ArrayList<Produit> clients = new ArrayList<>();
        while(rs.next()){
            Produit cl = new Produit();
            cl.setId(rs.getInt("id"));
            cl.setNom(rs.getString("nom"));
            cl.setLienimage(rs.getString("image"));
            clients.add(cl);
        }
        connection.close();
        return clients;
    }
    public void insertClient(Client client) throws Exception{
        String sql = "insert into client(nom,pass) values ('"+client.getNom()+"','"+client.getPass()+"')";
        String sql1 = "insert into cartebancaire(idclient,montant) values ("+getLastClient()+",20000)";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        stmt.executeUpdate(sql1);
        connection.close();
    }
    public int getLastClient() throws Exception{
        String sql = "select id from client order by id desc limit 1";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        int res = 0;
        while(rs.next()) res = rs.getInt("id");
        return res+1;
    }
    public void insertProduit(Produit produit) throws Exception{
        String sql = "insert into produit(nom,image) values ('"+produit.getNom()+"','"+produit.getLienimage()+"')";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }
    public static ArrayList<EnchereAction> getActionsEnchereById(int idenchere) throws Exception{
        String sql = "select * from venchereclient where idenchere="+idenchere;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<EnchereAction> res = new ArrayList<>();
        while(rs.next()){
            EnchereAction enchereAction = new EnchereAction();
            enchereAction.setIdenchere(rs.getInt("idenchere"));
            enchereAction.setIdclient(rs.getInt("idclient"));
            enchereAction.setMontant(rs.getInt("montant"));
            enchereAction.setDateaction(rs.getTimestamp("dateaction"));
            res.add(enchereAction);
        }
        connection.close();
        return res;
    }
    public static void updateEnchere(Enchere enchere) throws Exception {
        String sql = "update enchere set idproduit="+enchere.getIdproduit()+", datedebut='"+enchere.getDatedebut()+"',datefin='"+enchere.getDatefin()+"',montantdebase="+enchere.getMontantdebase()+" where id="+enchere.getId();
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }
    public ArrayList<Produit> getAllProduit() throws Exception{
        String sql = "select * from produit";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Produit> res = new ArrayList<>();
        while(rs.next()){
            Produit produit = new Produit();
            produit.setId(rs.getInt("id"));
            produit.setNom(rs.getString("nom"));
            produit.setLienimage(rs.getString("image"));
            res.add(produit);
        }
        connection.close();
        return res;
    }
    public static double getMontantClient(int idclient) throws Exception{
        String sql = "select montant from cartebancaire where idclient="+idclient;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        double res = 0;
        while(rs.next()) res = rs.getDouble("montant");
        connection.close();
        return res;
    }

    public static int getLastRechargement(int idclient) throws Exception{
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        String sql = "select id from rechargementcompte where idclient="+idclient+" order by id desc limit 1";
        ResultSet rs = stmt.executeQuery(sql);
        int res = 0;
        while(rs.next()) res = rs.getInt("id");
        connection.close();
        return res;
    }
    public static boolean validerRechargementcompte(int id,int idclient,double montant) throws Exception{
        double montantbase = getMontantClient(idclient);
        double montanttotal = montantbase+montant;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        String sql1 = "update rechargementcompte set valid='true' where id="+id;
        String sql2 = "update cartebancaire set montant="+montanttotal+" where idclient="+idclient;

            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);

        connection.close();
        return true;
    }
    public static boolean login(String nom, String pass) throws Exception {
        boolean res = false;
        ArrayList<Client> all = getAllClient();
        for (int i = 0; i < all.size(); i++) {
            if ((nom.equals(all.get(i).getNom())) && (pass.equals(all.get(i).getPass()))) {
                res = true;
            }
        }
        return res;
    }
    public static double getMaxMontantFromArchive() throws Exception{
        String sql1 = " select max(montant) from archive";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        double res = 0;
        ResultSet rs = stmt.executeQuery(sql1);
        while(rs.next()) res = rs.getDouble("max");
        connection.close();
        return res;
    }
    public static double getAllBeneficeFromArchive() throws Exception{
        String sql1 = "select sum(beneficeantsika) from archive";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        double res = 0;
        ResultSet rs = stmt.executeQuery(sql1);
        while(rs.next()) res = rs.getDouble("sum");
        connection.close();
        return res;
    }
    public Statistique getStatistique() throws Exception{
        Statistique res = new Statistique();
        res.setMaxenchere(getMaxMontantFromArchive());
        res.setTotalbenefice(getAllBeneficeFromArchive());
        return res;
    }
    public static ArrayList<Admin> getAllAdmin() throws Exception{
        ArrayList<Admin> res = new ArrayList<>();
        String sql = "select * from admin";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            Admin admin = new Admin();
            admin.setId(rs.getInt("id"));
            admin.setNom(rs.getString("nom"));
            admin.setPass(rs.getString("pass"));
            res.add(admin);
        }
        connection.close();
        return res;
    }
    public static boolean loginAdmin(String nom, String pass)throws Exception{
        boolean res = false;
        ArrayList<Admin> all = getAllAdmin();
        for(int i=0; i<all.size(); i++){
            if(nom.equals(all.get(i).getNom())&&pass.equals(all.get(i).getPass())){
                res = true;
            }
        }
        return res;
    }
    public static double getMontantLastMise(int idenchere) throws Exception{
        String sql = "select max(montant) from actionencherir where idenchere="+idenchere;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        double res = 0;
        while (rs.next()) res = rs.getDouble("max");
        connection.close();
        return res;
    }

    public static boolean debuteEnchere(int idproduit, int idclient, Timestamp datedebut, Timestamp datefin, double montantdebase) throws Exception{
        boolean res = false;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        String sql = "insert into enchere(idproduit,idclientdetenteur,datedebut,datefin,montantdebase) values ("+idproduit+","+idclient+",'"+datedebut+"','"+datefin+"',"+montantdebase+")";
        if(datefin.after(datedebut)){
            res = true;
            System.out.println(sql);
            stmt.executeUpdate(sql);
        }
        connection.close();
        return res;
    }

    public static double getMontantdeBase(int idenchere) throws Exception{
        String sql = "select montantdebase from enchere where id="+idenchere;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        double res = 0;
        while(rs.next()) res = rs.getDouble("montantdebase");
        connection.close();
        return res;
    }
    public static int getIdClientDetenteurEnchere(int idenchere) throws Exception{
        String sql = "select idclientdetenteur from enchere where id="+idenchere;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        int res = 0;
        while(rs.next()) res = rs.getInt("idclientdetenteur");
        connection.close();
        return res;
    }
    public static boolean checkEnchereIfAlreadyFinished(int idenchere, Timestamp dateaction) throws Exception{
        boolean res = false;
        String sql = "select datefin from enchere where id="+idenchere;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Timestamp datebase = null;
        while(rs.next()){
            datebase = rs.getTimestamp("datefin");
        }
        if(dateaction.before(datebase)){
            res = true;
        }
        connection.close();
        return res;
    }
    public static ArrayList<Integer> getAllEnchereWhereAClientIsInvolved(int idclient) throws Exception{
        String sql = "select distinct(idenchere) from actionencherir where idclient="+idclient;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Integer> res = new ArrayList<>();
        while(rs.next()){
            Integer i = rs.getInt("idenchere");
            res.add(i);
        }
        connection.close();
        return res;
    }public static double getUsedMoneyByIdEnchere(int idenchere, int idclient) throws Exception{
        String sql = "select montant from usedmoney where idclient="+idclient+" and idenchere="+idenchere+" order by montant desc limit 1";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        double res = 0;
        while(rs.next()) res = rs.getDouble("montant");
        connection.close();
        return res;
    }
    public static double getUsedMoney(int idclient) throws Exception{
        double toreturn = 0;
        ArrayList<Integer> idencheres = getAllEnchereWhereAClientIsInvolved(idclient);
        ArrayList<Double> res = new ArrayList<>();
        for(int i=0; i<idencheres.size(); i++){
            Double d = getUsedMoneyByIdEnchere(idencheres.get(i),idclient);
            res.add(d);
        }
        toreturn = res.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        return toreturn;
    }
    public static EnchereAction getLastMise(int idenchere) throws Exception{
        String sql = "select * from actionencherir where idenchere="+idenchere+" order by dateaction desc limit 1";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        EnchereAction enchereAction = new EnchereAction();
        while(rs.next()){
            enchereAction.setIdenchere(rs.getInt("idenchere"));
            enchereAction.setIdclient(rs.getInt("idclient"));
            enchereAction.setMontant(rs.getInt("montant"));
            enchereAction.setDateaction(rs.getTimestamp("dateaction"));
        }
        connection.close();
        return enchereAction;
    }
    public static double getMargeBeneficiaire() throws Exception{
        String sql = "select pourcentage from margebeneficiare";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        double res = 0;
        while(rs.next()) res = rs.getDouble("pourcentage");
        return res;
    }

    public static Timestamp getLastDateActionMise(int idenchere) throws Exception{
        String sql = "select dateaction from actionencherir where idenchere="+idenchere+" order by dateaction asc limit 1";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Timestamp timestamp = null;
        while(rs.next()) timestamp = rs.getTimestamp("dateaction");
        connection.close();
        return timestamp;
    }

    public static UsefulEntity encherir(int idenchere, int idclient, double montant, Timestamp dateaction) throws Exception{
        UsefulEntity res = new UsefulEntity();
        res.setState(false);
        Connection connection = connexion.getConn();
        double lastemise = getMontantLastMise(idenchere);
        System.out.println("laste mise="+lastemise);
        double debutenchere = getMontantdeBase(idenchere);
        System.out.println("debuteenchere="+debutenchere);
        Statement stmt = connection.createStatement();
        if(getLastDateActionMise(idenchere)!=null){
            System.out.println("ato am farany ambany 1");
            if((getIdClientDetenteurEnchere(idenchere)!=idclient)&&((montant>lastemise)&&(montant>=debutenchere))&&(dateaction.after(getLastDateActionMise(idenchere)))){
                if(checkEnchereIfAlreadyFinished(idenchere,dateaction)){
                    String sql = "insert into actionencherir(idenchere,idclient,montant,dateaction) values ";
                    String sql2 = "insert into usedmoney(idclient,montant,idenchere) values ";
                    double argentenCours = getUsedMoney(idclient);
                    double montantdebase = getMontantClient(idclient);
                    double montantrestant = montantdebase-argentenCours;
                    if(montant<montantrestant){
                        stmt.executeUpdate(sql2+"("+idclient+","+montant+","+idenchere+")");
                        stmt.executeUpdate(sql+"("+idenchere+","+idclient+","+montant+",'"+dateaction+"')");
                        res.setState(true);
                        res.setMessage("Vous avez encheri!");
                        return res;
                    }
                }
                else{
                    res.setMessage("Enchere Deja Terminee");
                    String sql = "insert into archive(idenchere,idclientgagnat,montant,beneficeantsika) values ";
                    EnchereAction lastAction = getLastMise(idenchere);
                    double beneficeazo = (lastAction.getMontant()*getMargeBeneficiaire())/100;
                    double reste = getMontantClient(lastAction.getIdclient())-lastAction.getMontant();
                    stmt.executeUpdate(sql+" ("+idenchere+","+lastAction.getIdclient()+","+lastAction.getMontant()+","+beneficeazo+")");
                    stmt.executeUpdate("update cartebancaire set montant="+reste+" where idclient="+lastAction.getIdclient());
                    stmt.executeUpdate("delete from usedmoney where idenchere="+idenchere);
                    stmt.executeUpdate("update enchere set state='true' where id="+idenchere);
                    connection.close();
                    return res;
                }
            }
            if(!res.getState()&&!Objects.equals(res.getMessage(), "")){
                res.setMessage("Vous ne Pouvez pas Encherir, soit vous etes le detenteur de l'enchere, soit vous n'avez pas assez d'argent");
            }
        }
        else {
            System.out.println("ato am farany ambany 2");
            System.out.println("tompony"+getIdClientDetenteurEnchere(idenchere));
            System.out.println("ilay miencherir"+idclient);
            System.out.println("laste mise="+lastemise);
            System.out.println("mise="+montant);
            System.out.println("montant de base="+debutenchere);
            if((getIdClientDetenteurEnchere(idenchere)!=idclient)&&((montant>lastemise)&&(montant>=debutenchere))){
                System.out.println("ambany 2 condition mety");
                if(checkEnchereIfAlreadyFinished(idenchere,dateaction)){
                    String sql = "insert into actionencherir(idenchere,idclient,montant,dateaction) values ";
                    String sql2 = "insert into usedmoney(idclient,montant,idenchere) values ";
                    double argentenCours = getUsedMoney(idclient);
                    double montantdebase = getMontantClient(idclient);
                    double montantrestant = montantdebase-argentenCours;
                    if(montant<montantrestant){
                        stmt.executeUpdate(sql2+"("+idclient+","+montant+","+idenchere+")");
                        stmt.executeUpdate(sql+"("+idenchere+","+idclient+","+montant+",'"+dateaction+"')");
                        res.setState(true);
                        res.setMessage("Vous avez encheri!");
                        return res;
                    }
                }
                else{
                    res.setMessage("Enchere Deja Terminee");
                    String sql = "insert into archive(idenchere,idclientgagnat,montant,beneficeantsika) values ";
                    EnchereAction lastAction = getLastMise(idenchere);
                    double beneficeazo = (lastAction.getMontant()*getMargeBeneficiaire())/100;
                    double reste = getMontantClient(lastAction.getIdclient())-lastAction.getMontant();
                    stmt.executeUpdate(sql+" ("+idenchere+","+lastAction.getIdclient()+","+lastAction.getMontant()+","+beneficeazo+")");
                    stmt.executeUpdate("update cartebancaire set montant="+reste);
                    stmt.executeUpdate("delete from usedmoney where idenchere="+idenchere);
                    stmt.executeUpdate("update enchere set state='true' where id="+idenchere);
                    connection.close();
                    return res;
                }
            }
            if(!res.getState()){
                res.setMessage("Vous ne Pouvez pas Encherir, soit vous etes le detenteur de l'enchere, soit vous n'avez pas assez d'argent");
            }
        }
        connection.close();
        return res;
    }

    public static ArrayList<EnchereAction> getAllEnchereAction(int idclient)throws Exception{
        ArrayList<EnchereAction> res = new ArrayList<>();
        String sql = "select * from historique where idclient="+idclient;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            EnchereAction enchereAction = new EnchereAction();
            enchereAction.setIdenchere(rs.getInt("idenchere"));
            enchereAction.setIdclient(rs.getInt("idclient"));
            enchereAction.setMontant(rs.getDouble("montant"));
            enchereAction.setDateaction(rs.getTimestamp("dateaction"));
            enchereAction.setImage(rs.getString("image"));
            enchereAction.setNom(rs.getString("nom"));
            res.add(enchereAction);
        }
        connection.close();
        return res;
    }

    public static void insertIntoRechargementCompte(int idclient,double montant) throws Exception{
        String sql = "insert into rechargementcompte(idclient,montant) values ";
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql+ "("+idclient+","+montant+")");
        connection.close();
    }

    public static ArrayList<Enchere> getAllEnchereByIdClientDetenteur(int idclient)throws Exception{
        ArrayList<Enchere> res = new ArrayList<>();
        String sql = "select * from enchere where idclientdetenteur="+idclient;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            Enchere enchere = new Enchere();
            enchere.setId(rs.getInt("id"));
            enchere.setIdproduit(rs.getInt("idproduit"));
            enchere.setIdclientdetenteur(rs.getInt("idclientdetenteur"));
            enchere.setDatedebut(rs.getTimestamp("datedebut"));
            enchere.setDatefin(rs.getTimestamp("datefin"));
            enchere.setMontantdebase(rs.getDouble("montantdebase"));
            enchere.setState(rs.getBoolean("state"));
            res.add(enchere);
        }
        connection.close();
        return res;
    }

    public static String getUrlImage(int id) throws Exception{
        String sql = "select image from enchere join produit on enchere.idproduit=produit.id where enchere.id="+id;
        Connection connection = connexion.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String res = "";
        while(rs.next()) res = rs.getString("image");
        connection.close();
        return res;
    }
    public static UsefulEntity loginV(String nom, String pass) throws Exception {
        UsefulEntity usefulEntity = new UsefulEntity();
        boolean res = false;
        ArrayList<Client> all = getAllClient();
        for (int i = 0; i < all.size(); i++) {
            if ((nom.equals(all.get(i).getNom())) && (pass.equals(all.get(i).getPass()))) {
                usefulEntity.setIdclient(all.get(i).getId());
                usefulEntity.setState(true);
            }
        }
        return usefulEntity;
    }
}
