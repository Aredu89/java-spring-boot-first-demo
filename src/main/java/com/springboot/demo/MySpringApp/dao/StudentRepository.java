package com.springboot.demo.MySpringApp.dao;

import com.springboot.demo.MySpringApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // No need to write any code.
    // JPA Repository provides all the CRUD operations and more.

    // Here we can add custom methods
    // In this case, findByName, JPA Data recognizes the field name and creates the query automatically.

    List<Student> findByLastName(String lastName);
}
