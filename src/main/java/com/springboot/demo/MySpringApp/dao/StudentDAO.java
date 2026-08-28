package com.springboot.demo.MySpringApp.dao;

import com.springboot.demo.MySpringApp.entity.Student;

import java.util.List;

// Not needed anymore. Replaced with JPA Data Repository implementation.
public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    Student update(Student student);

    void delete(Integer id);

    int deleteAll();
}
