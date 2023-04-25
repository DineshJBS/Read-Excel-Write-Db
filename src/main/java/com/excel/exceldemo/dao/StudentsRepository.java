package com.excel.exceldemo.dao;

import com.excel.exceldemo.entity.Student;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository  extends JpaRepository<Student, Integer> {
}
