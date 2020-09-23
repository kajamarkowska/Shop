package com.kaja.shop.config;

import com.kaja.shop.batch.ProductProcessor;
import com.kaja.shop.batch.ProductReader;
import com.kaja.shop.batch.ProductWriter;
import com.kaja.shop.batch.domain.ProductCSV;
import com.kaja.shop.domain.dao.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    private final ProductProcessor productProcessor;
    private final ProductReader productReader;
    private final ProductWriter productWriter;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public Job csvFileToDatabaseJob(String filepath) {
        return jobBuilderFactory.get("JobCsvDatabase")
                .incrementer(new RunIdIncrementer())
                .flow(stepFileToDatabase(filepath))
                .end()
                .build();
    }

    private Step stepFileToDatabase(String filepath) {
        return stepBuilderFactory.get("StepCsvDatabase")
                .<ProductCSV, Product>chunk(2)
                .reader(productReader.read(filepath))
                .processor(productProcessor)
                .writer(productWriter)
                .taskExecutor(taskExecutor())
                .build();
    }

    private TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor csvToDb = new SimpleAsyncTaskExecutor("CsvToDb");
        csvToDb.setConcurrencyLimit(5);
        return csvToDb;
    }


}
