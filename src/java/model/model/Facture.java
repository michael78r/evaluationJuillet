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
public class Facture extends DBTable {

    private String id;
    private String datefacturation;
    private String iddevis;
    private int numero;

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

    public int getLastNumero() throws Exception {
        Connection con = new Connexion().getConnection();
        Facture lp = new Facture();
        DBTable res = new Facture().find("select (numero) from Facture ORDER BY numero DESC LIMIT 1", con)[0];
        lp = (Facture) res;
        return lp.getNumero();
    }



    @Override
    public String getSeqName() {
        return "F";
    }

}
