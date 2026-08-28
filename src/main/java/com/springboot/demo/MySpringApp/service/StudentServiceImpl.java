package com.springboot.demo.MySpringApp.service;

import com.springboot.demo.MySpringApp.dao.StudentRepository;
import com.springboot.demo.MySpringApp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        Optional<Student> result = studentRepository.findById(id);

        Student theStudent = null;
        if(result.isPresent()) {
            theStudent = result.get();
        }
        else {
            // we didn't find the student
            throw new RuntimeException("Did not find student id - " + id);
        }
        return theStudent;
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

}
