/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import dbtable.Connexion;
import dbtable.DBTable;
import java.sql.Connection;

/**
 *
 * @author P14A_77_Michael
 */
public class Admin extends DBTable {

    private String id;
    private String nom;
    private String email;
    private String mdp;
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String getSeqName() {
        return "MAGASIN";
    }

    public Admin log() throws Exception {

        Admin admin = null;
        try {
            Connection con = new Connexion().getConnection();
            admin = new Admin();
            DBTable res = admin.find("select * from Admin where email='" + getEmail() + "' and mdp='" + getMdp() + "'", con)[0];
            admin = (Admin) res;
            return admin;
        } catch (Exception e) {
            throw new Exception("Username or password invalid");
        }

    }
}
