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

/**
 *
 * @author User
 */
public class V_depense extends DBTable {

    private String id;
    private String idbudget;
    private String nombudget;
    private String code;
    private BigDecimal prix;
    private BigDecimal prixannuel;
    private int mois;
    private int annee;
    private String realisation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public String getRealisation() {
        return realisation;
    }

    public void setRealisation(String realisation) {
        this.realisation = realisation;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public BigDecimal getPrixannuel() {
        return prixannuel;
    }

    public void setPrixannuel(BigDecimal prixannuel) {
        this.prixannuel = prixannuel;
    }

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

    public ArrayList<V_depense> getDepense() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<V_depense> lp = new ArrayList<>();
        String query = "SELECT a.*,  COALESCE(r.annee, "+getAnnee()+") AS annee,  COALESCE(r.mois, "+getMois()+") AS mois, COALESCE(r.prix, 0) AS prix, COALESCE(r.realisation, 0) AS realisation "
                + "FROM v_dep a LEFT JOIN v_alldepense r ON r.idbudget = a.id AND r.mois = "+getMois()+" and annee="+getAnnee();
        DBTable[] res = new V_depense().find(query, con);
        for (int i = 0; i < res.length; i++) {
            lp.add((V_depense) res[i]);
        }
        return lp;
    }

    @Override
    public String getSeqName() {
        return "";
    }

}
