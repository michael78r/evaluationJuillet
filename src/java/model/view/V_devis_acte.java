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
public class V_devis_acte extends DBTable {

    private String id;
    private String date;
    private BigDecimal prix;
    private String idbudget;
    private String nombudget;
    private int type;
    private String idpatient;
    private String nompatient;
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

    public String getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(String idpatient) {
        this.idpatient = idpatient;
    }

    public String getNompatient() {
        return nompatient;
    }

    public void setNompatient(String nompatient) {
        this.nompatient = nompatient;
    }

    public ArrayList<V_devis_acte> getActe() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<V_devis_acte> lp = new ArrayList<>();
        DBTable[] res = new V_devis_acte().find("select * from V_devis_acte", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((V_devis_acte) res[i]);
        }
        return lp;
    }

    public ArrayList<V_devis_acte> getActebymonth(int annee) throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<V_devis_acte> lp = new ArrayList<>();
        DBTable[] res = new V_devis_acte().find("select sum(prix) as prix,mois from v_devis_acte where annee=" + annee + " group by mois", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((V_devis_acte) res[i]);
        }

        return lp;
    }

    public ArrayList<V_devis_acte> getFacturebyPatient(String id) throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<V_devis_acte> lp = new ArrayList<>();
        DBTable[] res = new V_devis_acte().find("select * from v_devis_acte where idpatient='"+id+"' and id not in (select iddevis from facture)", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((V_devis_acte) res[i]);
        }

        return lp;
    }

    private ArrayList<V_devis_acte> getActeparmois(int annee) throws Exception {
        ArrayList<V_devis_acte> res = new ArrayList<>();
        ArrayList<V_devis_acte> res2 = new ArrayList<>();
        BigDecimal total = new BigDecimal(0);
        ArrayList<V_devis_acte> l = getActe();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getAnnee() == annee) {
                res2.add(l.get(i));
            }
        }
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getAnnee() == annee) {
                for (int j = 1; j <= 12; j++) {
                    if (l.get(i).getMois() == j) {
                        //total = total.add(l.get(i).getPrix());    

                    }
                }
                V_devis_acte v = new V_devis_acte();
                v.setPrix(total.add(l.get(i).getPrix()));
                v.setNombudget(l.get(i).getNombudget());
                res.add(v);

            }
        }
        System.out.println("total: " + total);
        return res;
    }

    @Override
    public String getSeqName() {
        return "";
    }
}
