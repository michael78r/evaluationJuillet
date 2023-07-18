/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import model.model.BeneficeBudget;
import model.model.BeneficeReel;
import model.model.Budget;
import model.model.Facture;
import model.view.V_depense;
import model.view.V_depense_total;
import model.view.V_devis_acte;
import model.view.V_devis_depense;
import model.view.V_recette;
import model.view.V_recette_total;
import util.Utilitaire;

/**
 *
 * @author User
 */
public class main {

    public static void main(String[] args) throws Exception {
        /* int mois = 6;
        int annee= 2023;
        V_recette rec = new V_recette();
        rec.setMois(mois);
        rec.setAnnee(annee);
        ArrayList<V_recette> r = rec.getRecette();
        V_depense dep = new V_depense();
        dep.setMois(mois);
        dep.setAnnee(annee);
        ArrayList<V_depense> d = dep.getDepense();

        V_recette_total rtotal = new V_recette_total();
        rtotal.setAnnee(annee);
        rtotal.setMois(mois);
        V_recette_total tr = rtotal.getTotalRecette();

        V_depense_total dtotal = new V_depense_total();
        dtotal.setAnnee(annee);
        dtotal.setMois(mois);
        V_depense_total td = dtotal.getTotalDepense();

        BeneficeReel b = new BeneficeReel();
        b.setDepense(td);
        b.setRecette(tr);
        BigDecimal br = b.getBeneficeReel();

        BeneficeBudget bt = new BeneficeBudget();
        bt.setDepense(td);
        bt.setRecette(tr);
        BigDecimal bb = bt.getBeneficeBudget();
        bt.setBr(b);
        BigDecimal rea = bt.getR();
        System.out.println(br);
        System.out.println(bb);*/
       
        System.out.println( Utilitaire.getConversion("05/03/2022"));

    }
}
