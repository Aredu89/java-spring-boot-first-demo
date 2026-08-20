package com.springboot.demo.MySpringApp.rest;

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

    private List<Student> theStudents;
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("John", "Doe", "jdoe@email.com"));
        theStudents.add(new Student("Mary", "Public", "mpublic@email.com"));
        theStudents.add(new Student("Bonita", "Applebum", "bapplebum@email.com"));
    }

    // define endpoint for "/students" - return list of students

     @GetMapping("/students")
     public List<Student> getStudents() {
         return theStudents;
     }

     @GetMapping("/students/{studentId}")
     public Student getStudent(@PathVariable int studentId) {

        //Check studentId against list size
         if(studentId >= theStudents.size() || studentId < 0) {
             throw new StudentNotFoundException("Student id not found: " + studentId);
         }
        return theStudents.get(studentId);
     }

     //Add exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
