/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.designers.utils;

import com.designers.dao.ProjectsDao;
import com.designers.domain.Image;
import com.designers.domain.Profile;
import com.designers.domain.Project;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfUtils {
    
    public static void exportPortfolio(Profile profile, List<Project> projects, File outputFile) throws IOException {
        
        // 1. Crear escritor y documento PDF
        PdfWriter writer = new PdfWriter(outputFile);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);
        
        // 2. Añadir información del perfil
        document.add(new Paragraph(profile.getName() + " " + profile.getLastname())
                         .setFontSize(18));
        document.add(new Paragraph("Teléfono: " + profile.getPhone()));
        document.add(new Paragraph("Resumen: " + profile.getSummary()));
        document.add(new Paragraph("\n"));  // salto de línea
        
        
        // 3. Recorrer cada proyecto
        for (Project p : projects) {
            // Título del proyecto
            document.add(new Paragraph(p.getName())
                             .setFontSize(14));
            // Descripción del proyecto
            document.add(new Paragraph(p.getDescription()));
            // Fechas de inicio/fin
            String fechas = p.isCurrentProject()
                            ? "Inicio: " + p.getStartDate() + " – Actualidad"
                            : "Inicio: " + p.getStartDate() + " – Fin: " + p.getFinishDate();
            document.add(new Paragraph(fechas));
            document.add(new Paragraph("\n"));  // espacio antes de imágenes

            // Obtener y añadir imágenes del proyecto
            List<Image> imgs = ProjectsDao.getImagesByProjectId(p.getIdProject());
            for (Image imgDomain : imgs) {
                // Convertir bytes a ImageData
                ImageData data = ImageDataFactory.create(imgDomain.getFile());
                // Crear elemento Image de iText y escalar para caber en página
                com.itextpdf.layout.element.Image pdfImg = new com.itextpdf.layout.element.Image(data)
                                   .scaleToFit(250, 250)
                                   .setMarginRight(10)  
                                   .setMarginBottom(10);
                document.add(pdfImg);
            }

            // Salto de página tras cada proyecto
            document.add(new AreaBreak());
        }

        // Cerrar el documento
        document.close();
        
    }
    
}
