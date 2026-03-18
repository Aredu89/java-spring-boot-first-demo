package com.springboot.demo.MySpringApp.config;

import com.springboot.demo.MySpringApp.entity.Coach;
import com.springboot.demo.MySpringApp.entity.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
