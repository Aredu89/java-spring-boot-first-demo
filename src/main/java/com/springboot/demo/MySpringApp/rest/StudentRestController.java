package com.springboot.demo.MySpringApp.rest;

import com.springboot.demo.MySpringApp.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return list of students

     @GetMapping("/students")
     public List<Student> getStudents() {
         List<Student> students = new ArrayList<>();
         students.add(new Student("John", "Doe"));
         students.add(new Student("Mary", "Public"));
         students.add(new Student("Bonita", "Applebum"));
         return students;
     }
}
