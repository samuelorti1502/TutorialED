package Formularios;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;

public class BackgroundImage1 {
    public static final String DEST = "src/Carnets/background_image.pdf";

    public static final String IMAGE = "src/Images/fondo1.png";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new BackgroundImage1().manipulatePdf(DEST);
        System.out.println("Hola2");
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize pageSize = PageSize.A4.rotate();
        Document doc = new Document(pdfDoc, pageSize);

        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
        canvas.addImageFittedIntoRectangle(ImageDataFactory.create(IMAGE), pageSize, false);

        doc.add(new Paragraph("Berlin!"));

        doc.close();
    }
}