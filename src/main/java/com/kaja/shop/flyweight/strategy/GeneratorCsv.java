package com.kaja.shop.flyweight.strategy;

import com.kaja.shop.generator.domain.FileType;
import com.kaja.shop.repository.ProductRepository;
import com.opencsv.CSVWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.StringWriter;

@RequiredArgsConstructor
@Component
public class GeneratorCsv implements  StrategyGenerator{

    private final ProductRepository productRepository;

    @Override
    public byte[] generateFile() {

        StringWriter stringWriter = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(stringWriter);
        csvWriter.writeNext(new String[]{
                "Id", "Name", "Description", "Quantity"
        });
        productRepository.findAll().forEach(product -> csvWriter.writeNext(new String[]{
                product.getId().toString(),
                product.getName(),
                product.getDescription(),
                product.getQuantity().toString(),

        }));


        return stringWriter.toString().getBytes();
    }

    @Override
    public FileType getType() {
        return FileType.CSV;
    }
}
