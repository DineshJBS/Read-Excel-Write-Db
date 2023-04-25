package com.excel.exceldemo.service;

import com.excel.exceldemo.dao.StudentsRepository;
import com.excel.exceldemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriteService {
    StudentsRepository studentsRepository;

    public WriteService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student uploadData(Student student){
        studentsRepository.save(student);
        return student;
    }

}
