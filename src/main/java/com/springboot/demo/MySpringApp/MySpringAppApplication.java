package com.springboot.demo.MySpringApp;

import com.springboot.demo.MySpringApp.dao.StudentDAO;
import com.springboot.demo.MySpringApp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(
		scanBasePackages = {
				"com.springboot.demo.MySpringApp.rest",
				"com.springboot.demo.MySpringApp.entity",
				"com.springboot.demo.MySpringApp.common",
				"com.springboot.demo.MySpringApp.config",
				"com.springboot.demo.MySpringApp.dao"
		}
)
public class MySpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students ...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numRowsDeleted + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
		System.out.println("Deleted student with id: " + studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Read student based on the id
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		// change first name
		System.out.println("Updating student ...");
		student.setFirstName("Scooby");

		// update student
		studentDAO.update(student);

		// display updated student
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// Get students
		List<Student> theStudents = studentDAO.findByLastName("Wall");

		// Display students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student createdStudent = createStudent(studentDAO);
		int theId = createdStudent.getId();
		System.out.println("Student generated id: " + theId);

		Student retrievedStudent = studentDAO.findById(theId);
		System.out.println("Found student: " + retrievedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "jdoe@email.com");
		Student tempStudent2 = new Student("Mary", "Public", "mpublic@email.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bapple@email.com");

		// Save the students
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private Student createStudent(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Wall", "pwall@email.com");

		// Save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//Display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		//Return student
		return tempStudent;
	}

}
