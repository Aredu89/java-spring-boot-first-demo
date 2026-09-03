package com.springboot.demo.MySpringApp.rest;

import com.springboot.demo.MySpringApp.entity.Student;
import com.springboot.demo.MySpringApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// Swagger OpenAPI: Generates the docs in http://localhost:8080/myapp/swagger-ui/index.html/
// Only if springdoc.enable-data-rest=false is present in the application.properties file.
// Otherwise, it will not work
// You can also see the api docs JSON generated in http://localhost:8080/myapp/v3/api-docs

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Having Srping Data REST in the POM file gives us all the CRUD endpoints for Free.

    // We keep here and in the Service only custom endpoints and methods
    @GetMapping("/students/search-by-last-name")
    public List<Student> findByLastName(@RequestParam String lastName) {
        return studentService.findByLastName(lastName);
    }


}
