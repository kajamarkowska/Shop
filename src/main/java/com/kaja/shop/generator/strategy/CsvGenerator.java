package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CsvGenerator extends GeneratorStrategy {
    public CsvGenerator() {
        super(FileType.CSV);
    }

    @Override
    public byte[] generateFile() {
        log.debug("CSV:");
        return new byte[0];
    }
}
