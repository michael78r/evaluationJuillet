/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import java.math.BigDecimal;
import model.view.V_depense_total;
import model.view.V_recette_total;

/**
 *
 * @author User
 */
public class BeneficeReel {
     
    private V_recette_total recette;
    private V_depense_total depense;
    private BigDecimal realisation;

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

    public BigDecimal getRealisation() {
        return realisation;
    }

    public void setRealisation(BigDecimal realisation) {
        this.realisation = realisation;
    }
    
    
    public BigDecimal getBeneficeReel(){
        BigDecimal res = new BigDecimal(0);
        res = getRecette().getSprix().subtract(getDepense().getSprix());
        return res;
    }
    
    
}
