/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import model.model.Chips;
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

    @RequestMapping(value = "/listechips", method = RequestMethod.GET)
    public String listechips(Model model) throws Exception {
        ArrayList<Chips> lc = new Chips().getChips();
        model.addAttribute("lc", lc);
        model.addAttribute("activeLink", "/listechips");
        return "listechips";
    }

    @RequestMapping(value = "/functionsetChips", method = RequestMethod.GET)
    public String chips(Model model, @RequestParam String nom, @RequestParam String prix) throws Exception {
        Chips c = new Chips();
        c.setNom(nom);
        c.setPrix(new BigDecimal(prix));
        c.create();
        return listechips(model);
    }

    @RequestMapping(value = "/functiondeleteChips", method = RequestMethod.GET)
    public String deletechips(Model model, @RequestParam String id) throws Exception {
        Chips c = new Chips();
        c.setId(id);
        c.delete();
        return listechips(model);
    }
}
