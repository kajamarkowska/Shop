package com.kaja.shop.controller;

import com.kaja.shop.flyweight.GenericFactory;
import com.kaja.shop.flyweight.strategy.StrategyGenerator;
import com.kaja.shop.generator.GeneratorFactory;
import com.kaja.shop.generator.domain.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

    private final GeneratorFactory generatorFactory;

    private final GenericFactory<FileType, StrategyGenerator> genericFactory;

    @GetMapping
    ResponseEntity<byte[]> getFile(@RequestParam FileType fileType){

        StrategyGenerator strategyGenerator = genericFactory.getByKey(fileType);
        byte[] file = strategyGenerator.generateFile();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_LENGTH, Integer.toString(file.length) );
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=report." + fileType.name().toLowerCase() );
        return ResponseEntity.ok().headers(httpHeaders).body(file);
    }




}
