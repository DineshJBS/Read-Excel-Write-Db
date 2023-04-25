package com.excel.exceldemo.service;

import com.excel.exceldemo.controller.WriteController;
import com.excel.exceldemo.entity.Student;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ReadService {

    private WriteController writeController;

    public ReadService(WriteController writeController) {
        this.writeController = writeController;
    }

    public void upload(MultipartFile file) throws Exception {

        Path temp = Files.createTempDirectory("");

        File theFile = temp.resolve(file.getOriginalFilename()).toFile();

        file.transferTo(theFile);


        Workbook workBook = WorkbookFactory.create(theFile);

        Sheet sheet = workBook.getSheetAt(0);

        Stream<Row> rowStream = StreamSupport.stream(sheet.spliterator(), false);


        rowStream.forEach(row -> {
            // get stream of cells from a row

            Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(), false);

            List<String> cellValues = cellStream.map(cell -> {
                String cellValue = cell.getStringCellValue();
                return cellValue;
            }).collect(Collectors.toList());

            System.out.println(cellValues);

            Student students = new Student(cellValues.get(0), cellValues.get(1));

            writeController.uploadData(students);

        });

    }



}
