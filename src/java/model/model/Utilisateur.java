/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import dbtable.Connexion;
import dbtable.DBTable;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author P14A_77_Michael
 */
public class Utilisateur extends DBTable {

    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String photo;
    private String mdp;

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Utilisateur> getUtilisateur() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<Utilisateur> lp = new ArrayList<>();
        DBTable[] res = new Utilisateur().find("select * from utilisateur", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((Utilisateur) res[i]);
        }
        return lp;
    }

    public Utilisateur log() throws Exception {

        Utilisateur utilisateur = null;
        try {
            Connection con = new Connexion().getConnection();
            utilisateur = new Utilisateur();
            DBTable res = utilisateur.find("select * from utilisateur where email='" + getEmail() + "' and mdp='" + getMdp() + "'", con)[0];
            utilisateur = (Utilisateur) res;
            return utilisateur;
        } catch (Exception e) {
            throw new Exception("Username or password invalid");
        }

    }

    /*public ArrayList<Utilisateur> getUtilisateur(Connection con) throws Exception {
        ArrayList<Utilisateur> lp = new ArrayList<>();
        DBTable[] res = new Utilisateur().find("select * from utilisateur where id not in (select idutilisateur from pointdevente)", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((Utilisateur) res[i]);
        }
        return lp;
    }*/
    @Override
    public String getSeqName() {
        return "UTILISATEUR";
    }

}
