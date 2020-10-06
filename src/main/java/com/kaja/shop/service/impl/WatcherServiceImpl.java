package com.kaja.shop.service.impl;

import com.kaja.shop.config.BatchConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class WatcherServiceImpl implements Runnable {

    private final JobLauncher jobLauncher;
    private final BatchConfig batchConfig;

    @Override
    public void run() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("C:\\Users\\Kaja\\Documents\\WatchFile");
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
            WatchKey watchKey;
            while ((watchKey = watchService.take()) != null) {
                watchKey.pollEvents().forEach(event -> {
                    Path filePath = Paths.get(path.toString(), event.context().toString());
                    if (Files.isRegularFile(filePath)) {
                        try {
                            jobLauncher.run(batchConfig.csvFileToDatabaseJob(filePath.toString()), new JobParametersBuilder()
                                    .addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters());
                        } catch (JobExecutionAlreadyRunningException | JobParametersInvalidException | JobInstanceAlreadyCompleteException | JobRestartException e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                });
                watchKey.reset();
            }
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }

    }
}
