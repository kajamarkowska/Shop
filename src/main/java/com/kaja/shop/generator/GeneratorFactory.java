package com.kaja.shop.generator;

import com.kaja.shop.generator.domain.FileType;
import com.kaja.shop.generator.strategy.GeneratorStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GeneratorFactory {

    private final List<GeneratorStrategy> generatorStrategies;

    private Map<FileType,GeneratorStrategy> strategyMap;

    @PostConstruct
    void init(){
       strategyMap = generatorStrategies.stream().collect(Collectors.toMap(GeneratorStrategy::getFileType,generatorStrategy -> generatorStrategy));
    }

    public GeneratorStrategy getByKey(FileType fileType){

        return strategyMap.get(fileType);

    }

}
