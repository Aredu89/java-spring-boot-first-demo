package com.springboot.demo.MySpringApp.service;

import com.springboot.demo.MySpringApp.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

    Student save(Student student);

    Student findById(int id);

    List<Student> findByLastName(String lastName);

    void deleteById(Integer id);

    void deleteAll();
}
