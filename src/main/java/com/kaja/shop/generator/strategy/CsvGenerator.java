package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class CsvGenerator extends GeneratorStrategy {
    public CsvGenerator() {
        super(FileType.CSV);
    }

    @Override
    public byte[] generateFile() {
        System.out.println("CSV: ");
        return new byte[0];
    }
}
