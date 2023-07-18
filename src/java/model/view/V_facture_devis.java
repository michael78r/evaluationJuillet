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
import model.model.Patient;

/**
 *
 * @author User
 */
public class V_facture_devis extends DBTable {

    private String id;
    private String datefacturation;
    private String iddevis;
    private String date;
    private BigDecimal prix;
    private String nombudget;
    private String nompatient;
    private int numero;
    private int etat;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatefacturation() {
        return datefacturation;
    }

    public void setDatefacturation(String datefacturation) {
        this.datefacturation = datefacturation;
    }

    public String getIddevis() {
        return iddevis;
    }

    public void setIddevis(String iddevis) {
        this.iddevis = iddevis;
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

    public String getNombudget() {
        return nombudget;
    }

    public void setNombudget(String nombudget) {
        this.nombudget = nombudget;
    }

    public String getNompatient() {
        return nompatient;
    }

    public void setNompatient(String nompatient) {
        this.nompatient = nompatient;
    }

    public ArrayList<V_facture_devis> getFacture() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<V_facture_devis> lp = new ArrayList<>();
        DBTable[] res = new V_facture_devis().find("select * from v_facture_devis", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((V_facture_devis) res[i]);
        }
        return lp;
    }

    public ArrayList<V_facture_devis> getFatureByNumero(int numero) throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<V_facture_devis> lp = new ArrayList<>();
        DBTable[] res = new V_facture_devis().find("select * from V_facture_devis where numero = " + numero, con);
        for (int i = 0; i < res.length; i++) {
            lp.add((V_facture_devis) res[i]);
        }
        return lp;
    }

    public BigDecimal getTotal(int numero) throws Exception {
        V_facture_devis v = new V_facture_devis();
        Connection con = new Connexion().getConnection();
        DBTable res = new V_facture_devis().find("select sum(prix) as prix from V_facture_devis where numero = " + numero, con)[0];
        v = (V_facture_devis) res;
        return v.getPrix();
    }

    @Override
    public String getSeqName() {
        return "";
    }

}
