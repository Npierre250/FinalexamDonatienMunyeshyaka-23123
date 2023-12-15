package com.example.military_managment_system.service;
import com.example.military_managment_system.model.Soldier;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class DatabasePDFService {
    public static ByteArrayInputStream employeePDFReport(List<Soldier> soldiers) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Military Structure", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(9);

            Stream.of("REGISTRATION_NO", "NATIONAL_ID", "FIRST_NAME", "LAST_NAME","NATIONALITY"
                    ,"SOLDIER_RANK", "GENDER","EMAIL","DATE_OF_BIRTH").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.CYAN);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });

            for (Soldier soldier : soldiers) {
                PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(soldier.getRegNo())));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell nationalIdCell = new PdfPCell(new Phrase(String.valueOf(soldier.getNationalId())));
                nationalIdCell.setPaddingLeft(4);
                nationalIdCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nationalIdCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(nationalIdCell);

                PdfPCell firstNameCell = new PdfPCell(new Phrase(soldier.getFirstName()));
                firstNameCell.setPaddingLeft(4);
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(firstNameCell);

                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(soldier.getLastName())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                lastNameCell.setPaddingRight(4);
                table.addCell(lastNameCell);


                PdfPCell countryCell = new PdfPCell(new Phrase(String.valueOf(soldier.getNationality())));
                countryCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                countryCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                countryCell.setPaddingRight(4);
                table.addCell(countryCell);

                PdfPCell rank = new PdfPCell(new Phrase(String.valueOf(soldier.getRank())));
                rank.setVerticalAlignment(Element.ALIGN_MIDDLE);
                rank.setHorizontalAlignment(Element.ALIGN_CENTER);
                rank.setPaddingRight(4);
                table.addCell(rank);

                PdfPCell genderCell = new PdfPCell(new Phrase(String.valueOf(soldier.getGender())));
                genderCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                genderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                genderCell.setPaddingRight(4);
                table.addCell(genderCell);


                PdfPCell emailCell = new PdfPCell(new Phrase(String.valueOf(soldier.getEmail())));
                emailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                emailCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                emailCell.setPaddingRight(4);
                table.addCell(emailCell);

                PdfPCell deptCell = new PdfPCell(new Phrase(String.valueOf(soldier.getDob().toString())));
                deptCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                deptCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                deptCell.setPaddingRight(4);
                table.addCell(deptCell);

            }
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
