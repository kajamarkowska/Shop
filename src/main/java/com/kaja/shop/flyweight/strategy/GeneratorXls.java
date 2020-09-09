package com.kaja.shop.flyweight.strategy;

import com.kaja.shop.generator.domain.FileType;
import com.kaja.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Component
@Slf4j
public class GeneratorXls implements StrategyGenerator {

    private final ProductRepository productRepository;

    @Override
    public byte[] generateFile() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {

            HSSFSheet sheet = workbook.createSheet("Report");
            HSSFRow row = sheet.createRow(0);
            row.createCell(0).setCellValue("Id");
            row.createCell(1).setCellValue("Name");
            row.createCell(2).setCellValue("Price");
            row.createCell(3).setCellValue("Quantity");

            AtomicInteger i = new AtomicInteger(1);

            productRepository.findAll().forEach(product -> {
                HSSFRow rowData = sheet.createRow(i.getAndIncrement());
                rowData.createCell(0).setCellValue(product.getId());
                rowData.createCell(1).setCellValue(product.getName());
                rowData.createCell(2).setCellValue(product.getPrice());
                rowData.createCell(3).setCellValue(product.getQuantity());
            });
            sheet.setAutoFilter(new CellRangeAddress(0, i.get(), 0, 3));


            workbook.write(byteArrayOutputStream);


        } catch (IOException e) {
           log.error(e.getMessage(),e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public FileType getType() {
        return FileType.XLS;
    }
}
