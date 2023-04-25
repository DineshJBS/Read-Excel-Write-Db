package com.excel.exceldemo.controller;

import com.excel.exceldemo.entity.Student;
import com.excel.exceldemo.service.WriteService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WriteController {

    private WriteService writeService;

    public WriteController(WriteService writeService) {
        this.writeService = writeService;
    }

    public Student uploadData(Student student){
        return writeService.uploadData(student);

    }


}
