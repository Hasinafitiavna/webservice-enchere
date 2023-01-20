package com.example.webservice.controller;

import com.example.webservice.enchere.Fonction;
import com.example.webservice.enchere.entity.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/encheres")
@CrossOrigin("*")
public class Controller {

    Fonction f = new Fonction();
    @GetMapping("getallclient")
    public ArrayList<Client> getAllC() throws Exception{
        return f.getAllClient();
    }
    @GetMapping("listeenchere")
    public ArrayList<ListeEnchere> getListeEnchere() throws Exception{
        return f.getAllEnchere();
    }
    @GetMapping("listeproduit")
    public ArrayList<Produit> getListeProduit() throws Exception{
        return f.getProduit();
    }
    @GetMapping("listerechargementcompte")
    public ArrayList<RechargementCompte> getrechargementcompte() throws Exception{
        return f.getAllRechargement();
    }
    @GetMapping("login/{nom}/{pass}")
    public boolean login(@PathVariable("nom") String nom, @PathVariable("pass") String pass) throws Exception{
        return f.login(nom,pass);
    }

    @GetMapping("client/{id}")
    public Client getClientById(@PathVariable("id") int id) throws Exception{
        return f.getClientById(id);
    }

    @GetMapping("getenchere/{id}")
    public ListeEnchere getEnchere(@PathVariable("id") int id) throws Exception{
        return f.getEnchere(id);
    }

    @GetMapping("getEncherebyId/{id}")
    public Enchere getEncherebyId(@PathVariable("id") int id) throws Exception{
        return f.getEncherebyId(id);
    }

    @GetMapping("insertclient/{client}")
    public void insertclient(@PathVariable("client") Client client) throws Exception{
        f.insertClient(client);
    }

    @GetMapping("insertproduit/{produit}")
    public void insertclient(@PathVariable("produit") Produit produit) throws Exception{
        f.insertProduit(produit);
    }

    @GetMapping("updateEnchere/{id}/{idproduit}/{datedebut}/{datefin}/{montant}")
    public void updateEnchere(@PathVariable("id") int id,@PathVariable("idproduit") int idproduit,@PathVariable("datedebut")String datedebut,@PathVariable("datefin")String datefin,@PathVariable("montant")int montant) throws Exception{
//        String dd=datedebut.replace("_",":");
//        String df=datedebut.replace("_",":");
        Enchere enchere=new Enchere(id,idproduit,datedebut,datefin,montant);
        f.updateEnchere(enchere);
    }

    @GetMapping("getdescription/{idenchere}")
    public ArrayList<EnchereAction> getAllC(@PathVariable("idenchere") int idenchere) throws Exception{
        return f.getActionsEnchereById(idenchere);
    }
    @GetMapping("validerRechargerCompte/{id}/{idclient}/{montant}")
    public void rechargercompte(@PathVariable("id") int id,@PathVariable("idclient") int idclient, @PathVariable("montant") double montant) throws Exception{
        f.validerRechargementcompte(id,idclient,montant);
    }
    @GetMapping("encherir/{idenchere}/{idclient}/{montant}/{dateaction}")
    public void encherir(@PathVariable("idenchere") int idenchere, @PathVariable("idclient") int idclient, @PathVariable("montant") double montant, @PathVariable("dateaction") Timestamp dateaction) throws Exception{
        f.encherir(idenchere,idclient,montant,dateaction);
    }
    @GetMapping("getStat")
    public Statistique getStat() throws Exception{
        return f.getStatistique();
    }
    @GetMapping("loginadmin/{nom}/{pass}")
    public boolean loginadmin(@PathVariable("nom") String nom,@PathVariable("pass") String pass) throws Exception{
        return f.loginAdmin(nom,pass);
    }
    @GetMapping("gethistorique/{idclient}")
    public ArrayList<EnchereAction> gethistorique(@PathVariable("idclient") int idclient) throws Exception{
        return f.getAllEnchereAction(idclient);
    }

}
