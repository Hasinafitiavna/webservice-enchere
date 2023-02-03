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

    @GetMapping("insertclient/{nom}/{pass}")
    public void insertclient(@PathVariable("nom") String nom,@PathVariable("pass") String pass) throws Exception{
        Client client=new Client();
        client.setNom(nom);
        client.setPass(pass);
        f.insertClient(client);
    }
    @GetMapping("inscription/{nom}/{mdp}")
    public void inscription(@PathVariable("nom") String nom,@PathVariable("mdp") String mdp) throws Exception{
        Client client= new Client(nom,mdp);
        f.insertClient(client);
    }

    @PostMapping("insertproduit")
    public void insertproduit(@RequestBody Produit produit) throws Exception{

        f.insertProduit(produit);
    }
    @GetMapping("updateEnchere/{id}/{idproduit}/{datedebut}/{datefin}/{montant}")
    public void updateEnchere(@PathVariable("id") int id,@PathVariable("idproduit") int idproduit,@PathVariable("datedebut")Timestamp datedebut,@PathVariable("datefin")Timestamp datefin,@PathVariable("montant")int montant) throws Exception{
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
    public UsefulEntity encherir(@PathVariable("idenchere") int idenchere, @PathVariable("idclient") int idclient, @PathVariable("montant") double montant, @PathVariable("dateaction")Timestamp dateaction) throws Exception{
        return f.encherir(idenchere,idclient,montant,dateaction);
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
    @GetMapping("insertIntoRechargementCompte/{idclient}/{montant}")
    public void insertRechargement(@PathVariable("idclient") int idclient,@PathVariable("montant") double montant) throws Exception{
        f.insertIntoRechargementCompte(idclient,montant);
    }
    @GetMapping("lienimage/{id}")
    public String lienimage(@PathVariable("id") int id) throws Exception{
        return f.getUrlImage(id);
    }
    @GetMapping("getallproduits")
    public ArrayList<Produit> getproduits() throws Exception{
        return f.getAllProduit();
    }
    @GetMapping("loginV/{nom}/{pass}")
    public UsefulEntity loginV(@PathVariable("nom") String nom, @PathVariable("pass") String pass) throws Exception{
        return f.loginV(nom,pass);
    }

    @GetMapping("debuterEnchere/{idproduit}/{idclient}/{datedebut}/{datefin}/{montant}")
    public boolean debuterEnchere(@PathVariable("idproduit") int idproduit,@PathVariable("idclient") int idclient,@PathVariable("datedebut") Timestamp datedebut,@PathVariable("datefin") Timestamp datefin,@PathVariable("montant") double montant) throws Exception{
        return f.debuteEnchere(idproduit,idclient,datedebut,datefin,montant);
    }

    @GetMapping("getallenchereClientDetenteur/{idclient}")
    public ArrayList<Enchere> getallenchereClient(@PathVariable("idclient") int idclient) throws Exception{
        return f.getAllEnchereByIdClientDetenteur(idclient);
    }

}
