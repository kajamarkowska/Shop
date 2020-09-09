package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DocGenerator extends GeneratorStrategy {
    public DocGenerator() {
        super(FileType.DOC);
    }

    @Override
    public byte[] generateFile() {
        log.info("Doc: ");
        return new byte[0];
    }
}
