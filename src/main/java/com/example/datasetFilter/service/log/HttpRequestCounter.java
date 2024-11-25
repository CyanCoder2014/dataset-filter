package com.example.datasetFilter.service.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class HttpRequestCounter {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestCounter.class);

    private final AtomicInteger requestCount = new AtomicInteger();

    public void increment() {
        int currentCount = requestCount.incrementAndGet();
        logger.info("HTTP request received. Total count: {}", currentCount);
    }

    public int getRequestCount() {
        return requestCount.get();
    }
}

