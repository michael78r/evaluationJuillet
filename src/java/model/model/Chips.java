/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import dbtable.Connexion;
import dbtable.DBTable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Chips extends DBTable {

    private String id;
    private String nom;
    private BigDecimal prix;

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

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public ArrayList<Chips> getChips() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<Chips> lp = new ArrayList<>();
        DBTable[] res = new Chips().find("select * from chips", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((Chips) res[i]);
        }
        return lp;

    }

    @Override
    public String getSeqName() {
        return "CHIPS";
    }

}
