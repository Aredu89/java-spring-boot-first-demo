package com.springboot.demo.MySpringApp;

import com.springboot.demo.MySpringApp.dao.StudentDAO;
import com.springboot.demo.MySpringApp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Wall", "pwall@email.com");

		// Save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//Display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
