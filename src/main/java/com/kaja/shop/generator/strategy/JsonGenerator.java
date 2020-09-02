package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class JsonGenerator extends GeneratorStrategy{
    public JsonGenerator() {
        super(FileType.JSON);
    }

    @Override
    public byte[] generateFile() {
        System.out.println("JSON: ");
        return new byte[0];
    }
}
