package com.kaja.shop.generator.strategy;

import com.kaja.shop.generator.domain.FileType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class GeneratorStrategy {

    @Getter
    private final FileType fileType;

    public abstract byte[] generateFile();
}
