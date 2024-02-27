package com.alhaj.jdbcconnection.repository;

import com.alhaj.jdbcconnection.model.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);
    List<Student> findAll();
}
