package com.springboot.demo.MySpringApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
		scanBasePackages = {
				"com.springboot.demo.MySpringApp.rest",
				"com.springboot.demo.MySpringApp.entity",
				"com.springboot.demo.MySpringApp.common",
				"com.springboot.demo.MySpringApp.config"
		}
)
public class MySpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (String[] args) {
		return runner -> {
			System.out.println("Hello World from CommandLineRunner");
		};
	}

}
