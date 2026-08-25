package com.springboot.demo.MySpringApp.service;

import com.springboot.demo.MySpringApp.dao.StudentDAO;
import com.springboot.demo.MySpringApp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Transactional
    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return studentDAO.findByLastName(lastName);
    }

    @Transactional
    @Override
    public Student update(Student student) {
        return studentDAO.update(student);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        studentDAO.delete(id);
    }

    @Transactional
    @Override
    public int deleteAll() {
        return studentDAO.deleteAll();
    }

}
