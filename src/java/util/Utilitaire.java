/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author P14A_77_Michael
 */
public class Utilitaire {

    public static String conversionDate(String dateString){
        LocalDate date = LocalDate.parse(dateString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRENCH);
        String formattedDate = formatter.format(date);
        return formattedDate;
    }
    
    public static String alignement(BigDecimal big) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        String formattedNumber = decimalFormat.format(big);
        return formattedNumber;
    }

    public static String getConversion(String dateStr) {
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
        if (mois == 13) {
            m = "13";
            return m;
        }
        if (mois == 14) {
            m = "14";
            return m;
        }
        if (mois == 15) {
            m = "15";
            return m;
        }
        if (mois == 16) {
            m = "16";
            return m;
        }
        if (mois == 17) {
            m = "17";
            return m;
        }
        if (mois == 18) {
            m = "18";
            return m;
        }
        if (mois == 19) {
            m = "19";
            return m;
        }
        if (mois == 20) {
            m = "20";
            return m;
        }
        if (mois == 21) {
            m = "21";
            return m;
        }
        if (mois == 22) {
            m = "22";
            return m;
        }
        if (mois == 23) {
            m = "23";
            return m;
        }
        if (mois == 24) {
            m = "24";
            return m;
        }
        if (mois == 25) {
            m = "25";
            return m;
        }
        if (mois == 26) {
            m = "26";
            return m;
        }
        if (mois == 27) {
            m = "27";
            return m;
        }
        if (mois == 28) {
            m = "28";
            return m;
        }
        if (mois == 29) {
            m = "29";
            return m;
        }
        if (mois == 30) {
            m = "30";
            return m;
        }
        if (mois == 31) {
            m = "31";
            return m;
        }

        return m;
    }
}
