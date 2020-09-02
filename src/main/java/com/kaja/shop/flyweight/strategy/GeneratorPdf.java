package com.kaja.shop.flyweight.strategy;

import com.kaja.shop.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class GeneratorPdf implements  StrategyGenerator{
    @Override
    public byte[] generateFile() {
        return new byte[0];
    }

    @Override
    public FileType getType() {
        return FileType.PDF;
    }
}
