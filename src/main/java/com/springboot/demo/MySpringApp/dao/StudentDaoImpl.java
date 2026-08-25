package com.springboot.demo.MySpringApp.dao;

import com.springboot.demo.MySpringApp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);

        // Return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theLastName", Student.class
        );

        // Set query parameters
        theQuery.setParameter("theLastName", lastName);

        // Return query results
        return theQuery.getResultList();
    }

    @Override
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void delete(Integer id) {
        // Find student by id
        Student student = entityManager.find(Student.class, id);

        // Delete student
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
