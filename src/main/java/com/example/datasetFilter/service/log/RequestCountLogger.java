package com.example.datasetFilter.service.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RequestCountLogger {

    @Autowired
    private HttpRequestCounter requestCounter;

    @Scheduled(fixedRate = 30000) // Log every 30 seconds
    public void logRequestCount() {
        int count = requestCounter.getRequestCount();
        Logger logger = LoggerFactory.getLogger(RequestCountLogger.class);
        logger.info("Total HTTP requests since startup: {}", count);
    }
}

