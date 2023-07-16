/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;

/**
 *
 * @author P14A_77_Michael
 */
public class Utilitaire {
    
    public static <T> List<T> paginate(List<T> liste, int isanyLigne, int pageApotra){
        int startIndex = (pageApotra-1)*isanyLigne;
        int endIndex= Math.min(startIndex+isanyLigne, liste.size());
        return liste.subList(startIndex, endIndex);
    } 

    public static String[] getAll(int nombre) {
        String[] resu = new String[nombre];
        String[] color = {"light", "active", "primary", "secondary", "success", "danger", "warning", "info","light","active","dark"};
        int icolor = 0;
        for (int i = 0; i < resu.length; i++) {
            if (icolor == color.length) {
                icolor = 0;
            }
            resu[i] = color[icolor];
            icolor = icolor + 1;

        }
        return color;
    }

    public static String[] get2(int nombre) {
        String[] resu = new String[nombre];
        String[] color = {"active", "primary"};
        int icolor = 0;
        for (int i = 0; i < resu.length; i++) {
            if (icolor == color.length) {
                icolor = 0;
            }
            resu[i] = color[icolor];
            icolor = icolor + 1;

        }
        return resu;
    }

    public static String[] get3(int nombre) {
        String[] resu = new String[nombre];
        String[] color = {"light", "active", "primary"};
        int icolor = 0;
        for (int i = 0; i < resu.length; i++) {
            if (icolor == color.length) {
                icolor = 0;
            }
            resu[i] = color[icolor];
            icolor = icolor + 1;

        }
        return resu;
    }

    public static String getMois(int mois) {
        String m = "";
        if (mois == 1) {
            m = "Janvier";
            return m;
        }
        if (mois == 2) {
            m = "Fevrier";
            return m;
        }
        if (mois == 3) {
            m = "Mars  ";
            return m;
        }
        if (mois == 4) {
            m = "Avril  ";
            return m;
        }
        if (mois == 5) {
            m = "Mai   ";
            return m;
        }
        if (mois == 6) {
            m = "Juin   ";
            return m;
        }
        if (mois == 7) {
            m = "Juillet ";
            return m;
        }
        if (mois == 8) {
            m = "Aout  ";
            return m;
        }
        if (mois == 9) {
            m = "Septembre";
            return m;
        }
        if (mois == 10) {
            m = "Octobre   ";
            return m;
        }
        if (mois == 11) {
            m = "Novembre";
            return m;
        }
        if (mois == 12) {
            m = "Decembre";
            return m;
        }
        return m;
    }
}
