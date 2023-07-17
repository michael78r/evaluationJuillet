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
 * @author User
 */
public class Patient extends DBTable {

    private String id;
    private String nom;
    private String datenaissance;
    private String genre;
    private int remboursement;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public int getRemboursement() {
        return remboursement;
    }

    public void setRemboursement(int remboursement) {
        this.remboursement = remboursement;
    }

    public ArrayList<Patient> getPatient() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<Patient> lp = new ArrayList<>();
        DBTable[] res = new Patient().find("select * from Patient", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((Patient) res[i]);
        }
        return lp;

    }

    @Override
    public String getSeqName() {
        return "PATIENT";
    }

}
