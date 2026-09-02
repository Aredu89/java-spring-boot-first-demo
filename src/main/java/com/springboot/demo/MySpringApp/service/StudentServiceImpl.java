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
    public List<Student> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

}
