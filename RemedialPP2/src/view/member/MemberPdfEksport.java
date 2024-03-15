package view.member;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.LineStyle;
import model.Member;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


import java.awt.Desktop;

public class MemberPdfExport {
    public void export(List<Member> memberList) throws IOException {
        String outputFileName = System.getProperty("user.dir") + File.separator + "pdf" + File.separator + "DaftarMember" + UUID.randomUUID() + ".pdf";

        PDFont fontPlain = PDType1Font.HELVETICA;
        PDFont fontBold = PDType1Font.HELVETICA_BOLD;

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        boolean drawContent = true;
        float bottomMargin = 70;

        BaseTable table = new BaseTable(yStartNewPage, yStartNewPage, bottomMargin, tableWidth, margin, document, page, true, drawContent);

        Row<PDPage> headerRow = table.createRow(50);
        Cell<PDPage> cell = headerRow.createCell(100, "Daftar Member");
        cell.setFont(fontBold);
        cell.setFontSize(20);
        cell.setValign(VerticalAlignment.MIDDLE);
        cell.setTopBorderStyle(new LineStyle(Color.BLACK, 10));
        table.addHeaderRow(headerRow);

        Row<PDPage> row = table.createRow(20);
        row.createCell(30, "No").setAlign(HorizontalAlignment.CENTER).setFontSize(15);
        row.createCell(40, "Nama").setAlign(HorizontalAlignment.CENTER).setFontSize(15);
        row.createCell(30, "Jenis Member").setAlign(HorizontalAlignment.CENTER).setFontSize(15);

        int no = 1;
        for (Member member : memberList) {
            row = table.createRow(20);
            row.createCell(30, String.valueOf(no)).setFontSize(15).setAlign(HorizontalAlignment.RIGHT);
            row.createCell(40, member.getNama()).setFontSize(15);
            row.createCell(30, member.getJenisMember().getNama()).setFontSize(15);
            no++;
        }

        table.draw();
        contentStream.close();

        document.save(outputFileName);
        document.close();

        File file = new File(outputFileName);
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) desktop.open(file);
    }
}
