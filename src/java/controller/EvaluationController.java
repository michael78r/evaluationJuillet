package controller;

import model.model.Admin;
import dbtable.Connexion;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.model.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author P14A_77_Michael
 *
 */
@Controller
public class EvaluationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) throws Exception {
        return "adminlogin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) throws Exception {
        model.addAttribute("activeLink", "/admin");
        return "admin";
    }

    @RequestMapping(value = "/utilisateurlogin", method = RequestMethod.GET)
    public String utilisateurlogin(Model model) throws Exception {
        return "utilisateurlogin";
    }

    @RequestMapping(value = "/utilisateur", method = RequestMethod.GET)
    public String utilisateur(Model model) throws Exception {
        model.addAttribute("activeLink", "/utilisateur");
        return "utilisateur";
    }

    @RequestMapping(value = "/functionlogAdmin", method = RequestMethod.GET)
    public String logAdmin(Model model, @RequestParam String email, @RequestParam String mdp, HttpServletRequest request) throws Exception {
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setMdp(mdp);
        try {
            Admin m = admin.log();
            HttpSession session = request.getSession();
            session.setAttribute("id", m.getId());
            session.setAttribute("nom", m.getNom());
            session.setAttribute("photo", m.getPhoto());
            model.addAttribute("activeLink", "/admin");
            return admin(model);
        } catch (Exception e) {
            model.addAttribute("erreur", e.getMessage());
            return "adminlogin";
        }
    }

    @RequestMapping(value = "/functionlogUtilisateur", method = RequestMethod.GET)
    public String logUtilisateur(Model model, @RequestParam String email, @RequestParam String mdp, HttpServletRequest request) throws Exception {
        Utilisateur ut = new Utilisateur();
        ut.setEmail(email);
        ut.setMdp(mdp);
        try {
            Utilisateur u = ut.log();
            HttpSession session = request.getSession();
            session.setAttribute("idutilisateur", u.getId());
            session.setAttribute("nomutilisateur", u.getNom());
            session.setAttribute("pv", u.getId());
            session.setAttribute("photoutilisateur", u.getPhoto());
            model.addAttribute("activeLink", "/utilisateur");
            return utilisateur(model);
        } catch (Exception e) {
            model.addAttribute("erreur", e.getMessage());
            return "utilisateurlogin";
        }
    }

    @RequestMapping(value = "/deconexion", method = RequestMethod.GET)
    public String deconexion(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        session.invalidate();
        return "adminlogin";
    }
}
