package com.kaja.shop.batch;

import com.kaja.shop.batch.domain.ProductCSV;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class ProductReader {

    @StepScope
    public ItemReader<ProductCSV> read(String filepath) {
        BeanWrapperFieldSetMapper<ProductCSV> mapper = new BeanWrapperFieldSetMapper<>();
        mapper.setTargetType(ProductCSV.class);
        return new FlatFileItemReaderBuilder<ProductCSV>().name("CsvProductReader")
                .linesToSkip(1)
                .resource(new FileSystemResource(filepath))
                .delimited()
                .names("name", "price", "quantity", "description")
                .fieldSetMapper(mapper)
                .build();
    }
}
