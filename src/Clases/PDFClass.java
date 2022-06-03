/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel David Ortiz
 */
public class PDFClass {

    private String modulo;
    private String id;
    private String nombre;
    private String fecha;

    private int tipo;
    private String ext;
    Date date = new Date();

    public PDFClass(String id, String nombre, String fecha) {
        this.setId(id);
        this.setNombre(nombre);
        this.setFecha(fecha);
    }

    public void createPDF() {
        PdfWriter pdfWriter = null;
        try {
            File file = new File("./src/Carnets/Carnet " + this.getId() + ".pdf");
            pdfWriter = new PdfWriter(file);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);

            Document document = new Document(pdfDocument);
            ImageData imageData = ImageDataFactory.create("./src/Images/fondo1.png");
            Image pdfImg = new Image(imageData);

            document.add(pdfImg);
            document.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PDFClass.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pdfWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(PDFClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void crearPDF() {
        Locale locale = new Locale("es", "ES");

        String nombreArchivo = "carnet " + this.getId() + ".pdf";
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd MMMMM yyyy");
        
        Rectangle tamaño = new Rectangle(360, 216);
        PageSize pageSize = new PageSize(tamaño);

        Date t = null;
        System.out.print(this.getFecha() + " Parses as ");
        try {
            t = formatter.parse(this.getFecha());
            System.out.println(t); 
            System.out.println(DateFor.format(t));
        } catch (ParseException ex) {
            System.out.println(ex);
        }

        try {

            PdfDocument pdf = new PdfDocument(new PdfWriter("./src/Carnets/" + nombreArchivo));
            Document doc = new Document(pdf, new PageSize(tamaño));
            doc.setMargins(10, 5, 10, 5);

            PdfCanvas canvas = new PdfCanvas(pdf.addNewPage());
            canvas.addImageFittedIntoRectangle(ImageDataFactory.create("./src/Images/fondo1.png"), pageSize, false);

            Table table = new Table(new float[2]).useAllAvailableWidth();
            //Table table = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();
            table.setMarginTop(0);
            table.setMarginBottom(0);

            Cell cell = new Cell(1, 1).add(createTextCell("TUTORIAL DE ESTRUCTURA DE DATOS UMG Versión 1.0", 3));
            table.addCell(createImageCell("./src/Images/umg.png", 35));
            table.addCell(cell);
            cell.setBorder(Border.NO_BORDER);

            Table table2 = new Table(UnitValue.createPercentArray(3));
            table2.setMarginTop(20);
            table2.setMarginLeft(5);

            table2.addCell(createImageCell("./src/Images/pinwi.png", 45));
            table2.addCell(createTextCell(this.getNombre(), 1));
            table2.addCell(createTextCell("", 3));
            
            table2.addCell(createTextCell("", 3));
            table2.addCell(createTextCell(DateFor.format(t), 1));
            table2.addCell(createTextCell("", 3));
            
            table2.addCell(createTextCell("", 3));
            table2.addCell(createTextCell("ID - " + this.getId(), 1));
            table2.addCell(createTextCell("", 3));

            doc.add(table);
            doc.add(table2);

            doc.close();

            //System.out.println(nombreArchivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PDFClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Cell createImageCell(String path, int tamaño) throws MalformedURLException {
        Image img = new Image(ImageDataFactory.create(path));
        img.setWidth(UnitValue.createPercentValue(tamaño));
        Cell cell = new Cell().add(img);
        cell.setBorder(Border.NO_BORDER);
        return cell;
    }

    private static Cell createTextCell(String text, int alineacion) {

        Cell cell = new Cell();
        Paragraph p = new Paragraph(text);

        switch (alineacion) {
            case 1:
                p.setTextAlignment(TextAlignment.RIGHT);
                break;
            case 2:
                p.setTextAlignment(TextAlignment.LEFT);
                break;
            case 3:
                p.setTextAlignment(TextAlignment.CENTER);
                break;
            case 4:
                p.setTextAlignment(TextAlignment.JUSTIFIED);
                break;
        }

        cell.add(p).setVerticalAlignment(VerticalAlignment.BOTTOM);
        cell.setBorder(Border.NO_BORDER);

        return cell;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
