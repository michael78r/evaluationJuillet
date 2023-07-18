/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import model.model.BeneficeBudget;
import model.model.BeneficeReel;
import model.model.Budget;
import model.model.Devis;
import model.model.Patient;
import model.view.V_depense;
import model.view.V_depense_total;
import model.view.V_devis_acte;
import model.view.V_devis_depense;
import model.view.V_recette;
import model.view.V_recette_total;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/listepatient", method = RequestMethod.GET)
    public String listepatient(Model model) throws Exception {
        ArrayList<Patient> lc = new Patient().getPatient();
        model.addAttribute("lp", lc);
        model.addAttribute("activeLink", "/listepatient");
        return "listepatient";
    }

    @RequestMapping(value = "/functionsetPatient", method = RequestMethod.GET)
    public String setPatient(Model model, @RequestParam String nom, @RequestParam String datenaissance, @RequestParam String genre, @RequestParam int remboursement) throws Exception {
        Patient c = new Patient();
        c.setNom(nom);
        c.setDatenaissance(datenaissance);
        c.setGenre(genre);
        c.setRemboursement(remboursement);
        c.create();
        return listepatient(model);
    }

    @RequestMapping(value = "/functiondeletePatient", method = RequestMethod.GET)
    public String deletepatient(Model model, @RequestParam String id) throws Exception {
        Patient c = new Patient();
        c.setId(id);
        c.delete();
        return listepatient(model);
    }

    //budget
    @RequestMapping(value = "/listebudget", method = RequestMethod.GET)
    public String listebudget(Model model) throws Exception {
        ArrayList<Budget> lc = new Budget().getBudget();
        model.addAttribute("lb", lc);
        model.addAttribute("activeLink", "/listebudget");
        return "listebudget";
    }

    @RequestMapping(value = "/functionsetBudget", method = RequestMethod.GET)
    public String setBudget(Model model, @RequestParam String nom, @RequestParam int type, @RequestParam String prix, @RequestParam String code) throws Exception {
        Budget c = new Budget();
        c.setNom(nom);
        c.setType(type);
        c.setPrix(new BigDecimal(prix));
        c.setCode(code);
        c.create();
        return listebudget(model);
    }

    @RequestMapping(value = "/functiondeleteBudget", method = RequestMethod.GET)
    public String deletebudget(Model model, @RequestParam String id) throws Exception {
        Budget c = new Budget();
        c.setId(id);
        c.delete();
        return listebudget(model);
    }

    //tableau de bord
    @RequestMapping(value = "/tableaudebord", method = RequestMethod.GET)
    public String tableaudebord(Model model, @RequestParam int annee, @RequestParam int mois) throws Exception {

        try{
        
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

        model.addAttribute("rea", rea);
        model.addAttribute("br", br);
        model.addAttribute("bb", bb);
        model.addAttribute("tr", tr);
        model.addAttribute("td", td);
        model.addAttribute("r", r);
        model.addAttribute("d", d);
        model.addAttribute("activeLink", "/tableaudebord");
        return "tableaudebord";
        }
        catch(Exception e){
            model.addAttribute("erreur",e.getMessage());
            return "exception";
        }
    }

}
