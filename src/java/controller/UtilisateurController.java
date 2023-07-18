/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileReader;
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
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import util.Pdf;
import util.Utilitaire;

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
                f.setEtat(0);
                f.create();
            }
        }
        ArrayList<V_facture_devis> f = new V_facture_devis().getFatureByNumero(numero);
        BigDecimal total = new V_facture_devis().getTotal(numero);
        Pdf.facturePDF(total, f);

        //Pdf.exportpdf("C:/Users/User/Desktop/EvaluationJuillet/facture.pdf");
        model.addAttribute("activeLink", "/infopatient");
        return infopatient(model, nom);
    }

    @RequestMapping(value = "/insertiondepense", method = RequestMethod.GET)
    public String insertiondepense(Model model) throws Exception {
        model.addAttribute("activeLink", "/insertiondepense");
        ArrayList<Budget> depense = new Budget().getDepense();
        model.addAttribute("depense", depense);
        return "insertiondepense";
    }

    @RequestMapping(value = "/functionsetdepense", method = RequestMethod.GET)
    public String setdepense(Model model, HttpServletRequest request) throws Exception {
        int jour = Integer.parseInt(request.getParameter("jour"));
        int annee = Integer.parseInt(request.getParameter("annee"));
        String prix = request.getParameter("prix");
        String nom = request.getParameter("nom");
        String[] mois = request.getParameterValues("mois");

        for (int i = 0; i < mois.length; i++) {
            String date = annee + "-" + Utilitaire.getChiifre(Integer.parseInt(mois[i]))+"-"+Utilitaire.getChiifre(jour);
            Devis c = new Devis();
            c.setDate(date);
            c.setPrix(new BigDecimal(prix));
            c.setIdbudget(nom);
            c.create();
        }
        return listedevis(model);
    }

    @RequestMapping(value = "/functionImporterCsv", method = RequestMethod.GET)
    public String setCsv(Model model, HttpServletRequest request) throws Exception {
        String csvFile = request.getParameter("csvFile");

        try (FileReader reader = new FileReader("C:/Users/User/Documents/NetBeansProjects/EvaluationJuillet/"+csvFile);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';'))) {

            for (CSVRecord csvRecord : csvParser) {

                String colonne1 = csvRecord.get(0);
                String colonne2 = csvRecord.get(1);
                String colonne3 = csvRecord.get(2);
                Budget b = new Budget();
                b.setCode(colonne2.toUpperCase());
                String code = b.getIdbyCode();
                Devis c = new Devis();
                c.setDate(Utilitaire.getConversion(colonne1));
                c.setIdbudget(code);
                c.setPrix(new BigDecimal(colonne3));
                c.create();
            }
            model.addAttribute("message","Importation réussie ");
            return listedevis(model);

        } catch (Exception e) {
            model.addAttribute("erreur",e);
            System.out.println("Erreur lors de l'importation du fichier CSV : " + e.getMessage());
            System.out.println(csvFile);
            return "exception";
        }
    }
    

    //model.addAttribute("activeLink", "/insertiondepense");
}
