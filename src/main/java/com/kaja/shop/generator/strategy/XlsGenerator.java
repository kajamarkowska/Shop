package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class XlsGenerator extends GeneratorStrategy {

    public XlsGenerator() {
        super(FileType.XLS);
    }

    @Override
    public byte[] generateFile() {
        log.info("Xls: ");
        return new byte[0];
    }
}
