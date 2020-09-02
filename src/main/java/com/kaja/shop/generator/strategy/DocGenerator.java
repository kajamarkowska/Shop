package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class DocGenerator extends GeneratorStrategy {
    public DocGenerator() {
        super(FileType.DOC);
    }

    @Override
    public byte[] generateFile() {
        System.out.println("Doc: ");
        return new byte[0];
    }
}
