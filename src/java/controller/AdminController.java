/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import model.model.Budget;
import model.model.Devis;
import model.model.Patient;
import model.view.V_devis_acte;
import model.view.V_devis_depense;
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
    public String setBudget(Model model, @RequestParam String nom, @RequestParam int type) throws Exception {
        Budget c = new Budget();
        c.setNom(nom);
        c.setType(type);
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
    public String tableaudebord(Model model) throws Exception {
        ArrayList<V_devis_acte> va = new V_devis_acte().getActebymonth(2023);
        ArrayList<V_devis_depense> vd = new V_devis_depense().getDepensebymonth(2023);
        model.addAttribute("acte", va);
        model.addAttribute("depense", vd);
        model.addAttribute("activeLink", "/tableaudebord");
        return "tableaudebord";
    }

}
