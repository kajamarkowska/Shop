package com.kaja.shop.flyweight.strategy;

import com.kaja.shop.generator.domain.FileType;
import com.kaja.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
@Component
@Slf4j
public class GeneratorDoc implements  StrategyGenerator {

    private final ProductRepository productRepository;

    @Override
    public byte[] generateFile() {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        row.getCell(0).setText("Name");
        row.addNewTableCell().setText("Description");
        row.addNewTableCell().setText("Quantity");
        row.addNewTableCell().setText("Price");
        productRepository.findAll().forEach(product -> {
            XWPFTableRow tableRow = table.createRow();
            tableRow.getCell(0).setText(product.getName());
            tableRow.getCell(1).setText(product.getDescription());
            tableRow.getCell(2).setText(product.getQuantity().toString());
            tableRow.getCell(3).setText(product.getPrice().toString());
        });
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            document.write(byteArrayOutputStream);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public FileType getType() {
        return FileType.DOC;
    }



}
