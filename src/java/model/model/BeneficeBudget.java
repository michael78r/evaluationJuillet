/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import model.view.V_depense_total;
import model.view.V_recette_total;

/**
 *
 * @author User
 */
public class BeneficeBudget {

    private V_recette_total recette;
    private V_depense_total depense;
    private BeneficeReel br;

    public BeneficeReel getBr() {
        return br;
    }

    public void setBr(BeneficeReel br) {
        this.br = br;
    }
    
    
    
    public V_recette_total getRecette() {
        return recette;
    }

    public void setRecette(V_recette_total recette) {
        this.recette = recette;
    }

    public V_depense_total getDepense() {
        return depense;
    }

    public void setDepense(V_depense_total depense) {
        this.depense = depense;
    }


    public BigDecimal getBeneficeBudget() {
        BigDecimal res = new BigDecimal(0);
        res = getRecette().getSprixannuel().subtract(getDepense().getSprixannuel());
        return res;
    }
    
    public BigDecimal getR(){
        BigDecimal res = new BigDecimal(0);
        res = getBr().getBeneficeReel().multiply(new BigDecimal(100)).divide(getBeneficeBudget(), 2, RoundingMode.HALF_UP);
        return res;
    }

}
