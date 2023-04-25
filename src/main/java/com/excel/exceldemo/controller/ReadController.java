package com.excel.exceldemo.controller;


import com.excel.exceldemo.service.ReadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ReadController {

    private ReadService readService;

    public ReadController(ReadService readService) {
        this.readService = readService;
    }

    @GetMapping("/hello")
    public String showHello(){
        return "Hello ";
    }



    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception{

        readService.upload(file);

        return "Hello World";
    }

}
