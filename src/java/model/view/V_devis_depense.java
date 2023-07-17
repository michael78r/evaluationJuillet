/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import dbtable.Connexion;
import dbtable.DBTable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import model.model.Devis;

/**
 *
 * @author User
 */
public class V_devis_depense extends DBTable {

    private String id;
    private String date;
    private BigDecimal prix;
    private String idbudget;
    private String nombudget;
    private int type;
    private int mois;
    private int annee;

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getIdbudget() {
        return idbudget;
    }

    public void setIdbudget(String idbudget) {
        this.idbudget = idbudget;
    }

    public String getNombudget() {
        return nombudget;
    }

    public void setNombudget(String nombudget) {
        this.nombudget = nombudget;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<V_devis_depense> getDepense() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<V_devis_depense> lp = new ArrayList<>();
        DBTable[] res = new V_devis_depense().find("select * from v_devis_depense", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((V_devis_depense) res[i]);
        }
        return lp;
    }

    public ArrayList<V_devis_depense> getDepensebymonth(int annee) throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<V_devis_depense> lp = new ArrayList<>();
        DBTable[] res = new V_devis_depense().find("select sum(prix) as prix,mois from V_devis_depense where annee=" + annee + " group by mois", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((V_devis_depense) res[i]);
        }

        return lp;
    }

    @Override
    public String getSeqName() {
        return "";
    }

}
