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
public class Budget extends DBTable {

    private String id;
    private String nom;
    private int type;

    
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<Budget> getBudget() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<Budget> lp = new ArrayList<>();
        DBTable[] res = new Budget().find("select * from budget", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((Budget) res[i]);
        }
        return lp;

    }

    public ArrayList<Budget> getActe() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<Budget> lp = new ArrayList<>();
        DBTable[] res = new Budget().find("select * from budget where type=0", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((Budget) res[i]);
        }
        return lp;
    }

    public ArrayList<Budget> getDepense() throws Exception {
        Connection con = new Connexion().getConnection();
        ArrayList<Budget> lp = new ArrayList<>();
        DBTable[] res = new Budget().find("select * from budget where type=1", con);
        for (int i = 0; i < res.length; i++) {
            lp.add((Budget) res[i]);
        }
        return lp;

    }

    @Override
    public String getSeqName() {
        return "BUDGET";
    }

}
