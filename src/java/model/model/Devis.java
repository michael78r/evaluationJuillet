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
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Devis extends DBTable {

    private String id;
    private String idbudget;
    private String date;
    private String idpatient;
    private BigDecimal prix;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdbudget() {
        return idbudget;
    }

    public void setIdbudget(String idbudget) {
        this.idbudget = idbudget;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(String idpatient) {
        this.idpatient = idpatient;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public ArrayList<Devis> getDevis() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<Devis> lp = new ArrayList<>();
        DBTable[] res = new Devis().find("select * from Devis", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((Devis) res[i]);
        }
        return lp;

    }

    @Override
    public String getSeqName() {
        return "DEVIS";
    }

}
