package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PdfGenerator extends GeneratorStrategy {
    public PdfGenerator() {
        super(FileType.PDF);
    }

    @Override
    public byte[] generateFile() {
        log.debug("Pdf: ");
        return new byte[0];
    }
}
