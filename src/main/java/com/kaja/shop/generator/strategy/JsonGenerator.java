package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JsonGenerator extends GeneratorStrategy {
    public JsonGenerator() {
        super(FileType.JSON);
    }

    @Override
    public byte[] generateFile() {
        log.debug("Json: ");
        return new byte[0];
    }
}
