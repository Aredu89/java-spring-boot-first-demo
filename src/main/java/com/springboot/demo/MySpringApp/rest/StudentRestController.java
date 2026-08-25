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

    // define endpoint for "/students" - return list of students
     @GetMapping("/students")
     public List<Student> findAll() {
         return studentService.findAll();
     };

    // add mapping for GET /students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }
        return student;
    }
}
