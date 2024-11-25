package com.example.datasetFilter.service.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomLogServiceImpl {

    @Async
    void countRequest(){

        log.info("log count called");

    }

}
