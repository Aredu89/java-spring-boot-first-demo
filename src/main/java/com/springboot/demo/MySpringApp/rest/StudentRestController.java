package com.springboot.demo.MySpringApp.rest;

import com.springboot.demo.MySpringApp.entity.Student;
import com.springboot.demo.MySpringApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;
    private JsonMapper jsonMapper;

    @Autowired
    public StudentRestController(StudentService studentService, JsonMapper jsonMapper) {
        this.studentService = studentService;
        this.jsonMapper = jsonMapper;
    }

    // Having Srping Data REST in the POM file gives us all the CRUD endpoints for Free.

    // We keep here and in the Service only custom endpoints and methods
    @GetMapping("/students/search-by-last-name")
    public List<Student> findByLastName(@RequestParam String lastName) {
        return studentService.findByLastName(lastName);
    }


}
