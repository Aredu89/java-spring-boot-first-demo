package com.springboot.demo.MySpringApp.service;

import com.springboot.demo.MySpringApp.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(int id);

    List<Student> findByLastName(String lastName);

    Student update(Student student);

    void delete(Integer id);

    int deleteAll();
}
