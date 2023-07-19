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
public class V_recette_total extends DBTable {

    private BigDecimal sprix;
    private BigDecimal sprixannuel;
    private BigDecimal sr;
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
    
    

    public BigDecimal getSprix() {
        return sprix;
    }

    public void setSprix(BigDecimal sprix) {
        this.sprix = sprix;
    }

    public BigDecimal getSprixannuel() {
        return sprixannuel;
    }

    public void setSprixannuel(BigDecimal sprixannuel) {
        this.sprixannuel = sprixannuel;
    }

    public BigDecimal getSr() {
        return sr;
    }

    public void setSr(BigDecimal sr) {
        this.sr = sr;
    }

    public V_recette_total getTotalRecette() throws Exception {
        Connection con = new Connexion().getConnection();
        V_recette_total t = new V_recette_total();
        String query = "SELECT a.*,  COALESCE(r.annee, "+getAnnee()+") AS annee,  COALESCE(r.mois, "+getMois()+") AS mois, COALESCE(r.prix, 0) AS prix, COALESCE(r.realisation, 0) AS realisation "
                + "FROM v_acte a LEFT JOIN v_allrecette r ON r.idbudget = a.id AND r.mois = "+getMois()+" and annee="+getAnnee();
        DBTable res = t.find("select mois,annee,sum(prix) as sprix, sum(prixannuel) as sprixannuel, round(((sum(prix)*100)/sum(prixannuel)),2) as sr from ("+query+") as totalreq group by mois,annee", con)[0];
        t = (V_recette_total) res;
        return t;
    }

    @Override
    public String getSeqName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

//select mois,annee,sum(prix) as sprix, sum(prixannuel) as sprixannuel, round(((sum(prix)*100)/sum(prixannuel)),2) as sr from (SELECT a.*,  COALESCE(r.annee, 2023) AS annee,  COALESCE(r.mois, 2) AS mois, COALESCE(r.prix, 0) AS prix, COALESCE(r.realisation, 0) AS realisation FROM v_acte a LEFT JOIN v_allrecette r ON r.idbudget = a.id AND r.mois = 2) as subquery group by mois,annee;
