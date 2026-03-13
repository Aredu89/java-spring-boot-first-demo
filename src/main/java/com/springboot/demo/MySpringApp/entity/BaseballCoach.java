package com.springboot.demo.MySpringApp.entity;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice.";
    }
}
