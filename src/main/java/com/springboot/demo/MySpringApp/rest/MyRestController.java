package com.springboot.demo.MySpringApp.rest;

import com.springboot.demo.MySpringApp.entity.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Value("${team.name}")
    private String teamName;
    private Coach myCoach;
    private Coach anotherCoach;
    // add code to expose "/" that return "Hello World"

    @GetMapping("/")
     public String sayHello() {
         return "Edited. Team Name: " + teamName;
     }

     // Define a constructor for dependency injection
    @Autowired
     public MyRestController(
             @Qualifier("tennisCoach") Coach theCoach,
             @Qualifier("tennisCoach") Coach theOtherCoach
    ) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theOtherCoach;
     }

    // setter method for dependency injection
    // This function could have any name
//    @Autowired
//    public void setMyCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }

     @GetMapping("/dailyworkout")
     public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
     }

     @GetMapping("/check")
    public String check() {
        boolean result = (myCoach == anotherCoach);
        return "Pointing to the same object: " + result;
    }
}
