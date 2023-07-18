/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import model.view.V_facture_devis;

/**
 *
 * @author P14A_77_Michael
 */
public class Pdf {

    public static void facturePDF(BigDecimal total, ArrayList<V_facture_devis> la) {

        String outputFile = "C:/Users/User/Desktop/EvaluationJuillet/" + la.get(0).getNompatient() + ".pdf";

        try {
            // Initialize document and set page size
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            document.open();

            // Add a title to the document
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Facture " + la.get(0).getNompatient(), titleFont);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(20f);
            table.setSpacingAfter(20f);

            // Set table headers
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            PdfPCell cellDateacte = new PdfPCell(new Paragraph("Date acte", headerFont));
            PdfPCell cellDesignation = new PdfPCell(new Paragraph("Nom budget", headerFont));
            PdfPCell cellPrix = new PdfPCell(new Paragraph("Prix", headerFont));

            table.addCell(cellDateacte);
            table.addCell(cellDesignation);
            table.addCell(cellPrix);

            for (V_facture_devis a : la) {
                // Add medical data to the table (example data)
                table.addCell(Utilitaire.datelettre(a.getDate()));
                table.addCell(a.getNombudget());
                table.addCell(a.getPrix().toString());
            }

            // Add more rows of medical data as needed
            // Add the table to the document
            document.add(table);

            // Calculate and add the total
            Paragraph totalParagraph = new Paragraph("Total :" + total + " Ar");
            totalParagraph.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(totalParagraph);
            Paragraph datefacturation = new Paragraph("Le :" + Utilitaire.datelettre(la.get(0).getDatefacturation()));
            datefacturation.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(datefacturation);
            Paragraph patient = new Paragraph("Patient :" + la.get(0).getNompatient());
            patient.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(patient);

            // Close the document
            document.close();

            System.out.println("Medical invoice created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void exportpdf(String filePath) throws BadElementException, IOException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(new Paragraph("FACTURE"));
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(5); // Exemple avec 3 colonnes
            // Ajouter des cellules au tableau
            table.addCell("Numero facture");
            table.addCell("Nom budget");
            table.addCell("Nom client");
            table.addCell("Date");
            table.addCell("Montant");
            document.add(new Paragraph("Facture"));
            document.add(table);

            document.close();

            System.out.println("Le fichier PDF a été créé avec succès.");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
