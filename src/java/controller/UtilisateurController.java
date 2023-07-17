/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.model.Budget;
import model.model.Devis;
import model.model.Facture;
import model.model.Patient;
import model.model.Utilisateur;
import model.view.V_devis_acte;
import model.view.V_devis_depense;
import model.view.V_facture_devis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import util.Pdf;

/**
 *
 * @author User
 */
@Controller
public class UtilisateurController {

    //devis
    @RequestMapping(value = "/listedevis", method = RequestMethod.GET)
    public String listedevis(Model model) throws Exception {
        ArrayList<Budget> acte = new Budget().getActe();
        ArrayList<Budget> depense = new Budget().getDepense();
        ArrayList<V_devis_acte> v_acte = new V_devis_acte().getActe();
        ArrayList<V_devis_depense> v_depense = new V_devis_depense().getDepense();
        ArrayList<Patient> p = new Patient().getPatient();
        model.addAttribute("acte", acte);
        model.addAttribute("depense", depense);
        model.addAttribute("v_acte", v_acte);
        model.addAttribute("v_depense", v_depense);
        model.addAttribute("p", p);
        model.addAttribute("activeLink", "/listedevis");
        return "listedevis";
    }

    @RequestMapping(value = "/functionsetDevis", method = RequestMethod.GET)
    public String setDevis(Model model, @RequestParam int type, @RequestParam String acte, @RequestParam String depense, @RequestParam String date, @RequestParam String idpatient, @RequestParam String prix) throws Exception {
        Devis c = new Devis();
        if (type == 1) {
            c.setDate(date);
            c.setPrix(new BigDecimal(prix));
            c.setIdbudget(depense);
            c.create();
        }
        if (type == 0) {
            c.setDate(date);
            c.setPrix(new BigDecimal(prix));
            c.setIdbudget(acte);
            c.setIdpatient(idpatient);
            c.create();
        }

        return listedevis(model);
    }

    @RequestMapping(value = "/functiondeleteDevis", method = RequestMethod.GET)
    public String deleteDevis(Model model, @RequestParam String id) throws Exception {
        Devis c = new Devis();
        c.setId(id);
        c.delete();
        return listedevis(model);
    }

    //facture
    @RequestMapping(value = "/infopatient", method = RequestMethod.GET)
    public String infopatient(Model model, @RequestParam String nom) throws Exception {
        try {
            ArrayList<V_devis_acte> v_acte = new V_devis_acte().getFacturebyPatient(nom);
            ArrayList<Patient> p = new Patient().getPatient();
            ArrayList<V_facture_devis> f = new V_facture_devis().getFacture();
            Integer lastId = new Facture().getLastNumero();
            model.addAttribute("acte", v_acte);
            model.addAttribute("p", p);
            model.addAttribute("nom", nom);
            model.addAttribute("f", f);
            model.addAttribute("lastID", lastId);
            model.addAttribute("activeLink", "/infopatient");
            return "infopatient";
        } catch (Exception e) {
            ArrayList<V_devis_acte> v_acte = new V_devis_acte().getFacturebyPatient(nom);
            ArrayList<Patient> p = new Patient().getPatient();
            ArrayList<V_facture_devis> f = new V_facture_devis().getFacture();
            Integer lastId = 1;
            model.addAttribute("acte", v_acte);
            model.addAttribute("p", p);
            model.addAttribute("nom", nom);
            model.addAttribute("f", f);
            model.addAttribute("lastID", lastId);
            model.addAttribute("activeLink", "/infopatient");
            return "infopatient";
        }

    }

    @RequestMapping(value = "/facture", method = RequestMethod.GET)
    public String facture(Model model, HttpServletRequest request) throws Exception {
        int num = Integer.parseInt(request.getParameter("num"));
        int numero = num + 1;
        String[] id = request.getParameterValues("id");
        String nom = request.getParameter("nom");
        if (id != null) {
            for (int i = 0; i < id.length; i++) {
                Facture f = new Facture();
                f.setDatefacturation(LocalDate.now().toString());
                f.setIddevis(id[i]);
                f.setNumero(numero);
                f.create();
            }
        }
        ArrayList<V_facture_devis> f = new V_facture_devis().getFatureByNumero(numero);
        BigDecimal total = new V_facture_devis().getTotal(numero);
        Pdf.facturePDF(total,f);

        //Pdf.exportpdf("C:/Users/User/Desktop/EvaluationJuillet/facture.pdf");
        model.addAttribute("activeLink", "/infopatient");
        return infopatient(model, nom);
    }
}
