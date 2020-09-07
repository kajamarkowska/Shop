package com.kaja.shop.flyweight.strategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaja.shop.generator.domain.FileType;
import com.kaja.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
@Slf4j
public class GeneratorJson implements StrategyGenerator {

    private final ProductRepository productRepository;

    private final ObjectMapper objectMapper;

    @Override
    public byte[] generateFile() {


        try {
            return objectMapper.writeValueAsBytes(productRepository.findAll());
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }

        return new byte[0];
    }

    @Override
    public FileType getType() {
        return FileType.JSON;
    }
}
