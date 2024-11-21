package com.example.datasetFilter.api.controller;

import com.example.datasetFilter.exceptions.BadRequestException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
public class HomeController {


    @GetMapping()
    public String importData() {
        return "welcome to the project";
    }

}
