package com.kaja.shop.flyweight.strategy;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.kaja.shop.generator.domain.FileType;
import com.kaja.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@RequiredArgsConstructor
@Component
@Slf4j
public class GeneratorPdf implements StrategyGenerator {

    private final ProductRepository productRepository;

    @Override
    public byte[] generateFile() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();

            PdfPTable table = new PdfPTable(4);
            table.addCell("Id");
            table.addCell("Name");
            table.addCell("Price");
            table.addCell("Quantity");

            productRepository.findAll().forEach(product -> {
                table.addCell(product.getId().toString());
                table.addCell(product.getName());
                table.addCell(product.getPrice().toString());
                table.addCell(product.getQuantity().toString());

            });

            document.add(table);
            document.close();

        } catch (DocumentException e) {
           log.error(e.getMessage(),e);

        }

        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public FileType getType() {
        return FileType.PDF;
    }
}
