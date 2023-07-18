/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author P14A_77_Michael
 */
public class Utilitaire {

    public static String getConversion(String dateStr){
     //String dateStr = "05/03/2022";
        
        // Conversion avec SimpleDateFormat
        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date date = inputFormat.parse(dateStr);
            String convertedDate = outputFormat.format(date);
            System.out.println("Format SimpleDateFormat : " + convertedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // Conversion avec LocalDate et DateTimeFormatter
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
        String convertedDate = localDate.format(outputFormatter);
        return convertedDate;
    }
    
    public static String datelettre(String date) {
        String moisEnLettres = "";
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
        try {
            Date d = inputFormat.parse(date);
            moisEnLettres = outputFormat.format(d);
            //System.out.println(moisEnLettres);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return moisEnLettres;
    }

    public static <T> List<T> paginate(List<T> liste, int isanyLigne, int pageApotra) {
        int startIndex = (pageApotra - 1) * isanyLigne;
        int endIndex = Math.min(startIndex + isanyLigne, liste.size());
        return liste.subList(startIndex, endIndex);
    }

    public static String[] getAll1(int nombre) {
        String[] resu = new String[nombre];
        String[] color = {"light", "active", "primary", "secondary", "success", "danger", "warning", "info", "light", "active", "dark"};
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

    public static String[] getAll(int nombre) {
        String[] resu = new String[nombre];
        String[] color = {"active", "primary", "secondary", "success", "danger", "warning", "info", "active", "active", "primary", "secondary", "success", "danger", "warning", "info", "light", "active", "dark"};
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
    
    
        public static String getChiifre(int mois) {
        String m = "";
        if (mois == 1) {
            m = "01";
            return m;
        }
        if (mois == 2) {
            m = "02";
            return m;
        }
        if (mois == 3) {
            m = "03";
            return m;
        }
        if (mois == 4) {
            m = "04";
            return m;
        }
        if (mois == 5) {
            m = "05";
            return m;
        }
        if (mois == 6) {
            m = "06";
            return m;
        }
        if (mois == 7) {
            m = "07";
            return m;
        }
        if (mois == 8) {
            m = "08";
            return m;
        }
        if (mois == 9) {
            m = "09";
            return m;
        }
        if (mois == 10) {
            m = "10";
            return m;
        }
        if (mois == 11) {
            m = "11";
            return m;
        }
        if (mois == 12) {
            m = "12";
            return m;
        }
        return m;
    }
}
