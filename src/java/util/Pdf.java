/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dbtable.Connexion;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Map;
/**
 *
 * @author P14A_77_Michael
 */
public class Pdf {

    public static void main(String[] args) throws Exception {
        //Connection con = new Connexion().getConnection();
        //Map<Integer, Integer> v = new V_sortiepointdevente().getMontantsortieparmoisparpv(con, "POINTDEVENTE1");
        //exportPDF("C:/Users/P14A_77_Michael/Documents/NetBeansProjects/WebA/pdf/vente.pdf", "Vente par mois", v);
    }

    public static void exportPDF(String filePath, String titre, Map<Integer, Integer> content) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();
            document.add(new Paragraph(titre));
            document.add(new Paragraph(" "));
            for (Map.Entry<Integer, Integer> entry : content.entrySet()) {
                int m = entry.getKey();
                String mois = Utilitaire.getMois(m);
                int quantite = entry.getValue();
                if (quantite > 0) {
                    String p = "";
                    p += " " + mois + " -- Montant :  " + quantite;
                    document.add(new Paragraph(p));
                }
            }
            //document.add(new Paragraph(p));
            document.close();

            System.out.println("Le fichier PDF a été créé avec succès.");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
