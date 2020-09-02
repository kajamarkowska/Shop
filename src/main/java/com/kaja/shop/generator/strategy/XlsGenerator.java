package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class XlsGenerator extends GeneratorStrategy {

    public XlsGenerator() {
        super(FileType.XLS);
    }

    @Override
    public byte[] generateFile() {
        System.out.println("Xls: ");
        return new byte[0];
    }
}
