package com.springboot.demo.MySpringApp.rest;

import com.springboot.demo.MySpringApp.dao.StudentDAO;
import com.springboot.demo.MySpringApp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentDAO studentDAO;

    // Quick and dirty: inject Student DAO (use constructor injection)
    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    // define endpoint for "/students" - return list of students
     @GetMapping("/students")
     public List<Student> findAll() {
         return studentDAO.findAll();
     };
}
