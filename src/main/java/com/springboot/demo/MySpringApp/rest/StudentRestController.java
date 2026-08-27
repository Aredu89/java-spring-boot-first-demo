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

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        // Just in case an id is passed in the JSON, set id to 0
        // So we save a new item instead of updating an existing one
        student.setId(0);
        Student dbStudent = studentService.update(student);

        return dbStudent;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        Student dbStudent = studentService.update(student);

        return dbStudent;
    }

    @PatchMapping("/students/{studentId}")
    public Student patchStudent(@PathVariable int studentId, @RequestBody Map<String, Object> patchPayload) {
        Student student = studentService.findById(studentId);

        if(student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        if(patchPayload.containsKey("id")) {
            throw new RuntimeException("Student id not allowed in the request body");
        }

        // Apply the patch to the student object
        Student patchedStudent = jsonMapper.updateValue(student, patchPayload);

        return studentService.update(patchedStudent);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.delete(studentId);
    }
}
