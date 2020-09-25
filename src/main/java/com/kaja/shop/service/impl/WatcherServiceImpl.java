package com.kaja.shop.service.impl;

import com.kaja.shop.config.BatchConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class WatcherServiceImpl implements  Runnable{

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

            }
            } catch(IOException | InterruptedException e){
                log.error(e.getMessage(), e);
            }

    }
}
