package com.springboot.demo.MySpringApp.rest;

import com.springboot.demo.MySpringApp.entity.Student;
import com.springboot.demo.MySpringApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

     @GetMapping("/students")
     public List<Student> findAll() {
         return studentService.findAll();
     };


}
