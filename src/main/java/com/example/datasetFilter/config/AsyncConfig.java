package com.example.datasetFilter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Value("${spring.threads.virtual.enabled:true}")
    private boolean virtualThreadsEnabled;

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        if (virtualThreadsEnabled) {
            return Executors.newVirtualThreadPerTaskExecutor();
        } else {
            return Executors.newFixedThreadPool(10); // or any other executor
        }
    }
}
