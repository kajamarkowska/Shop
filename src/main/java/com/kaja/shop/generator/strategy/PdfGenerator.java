package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class PdfGenerator extends GeneratorStrategy {
    public PdfGenerator() {
        super(FileType.PDF);
    }

    @Override
    public byte[] generateFile() {
        System.out.println("Pdf: ");
        return new byte[0];
    }
}
