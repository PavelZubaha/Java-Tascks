package com.pzubaha.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringCoach implements Coach {

    private FortuneService fortuneService;

    //Setting name with annotation
//    @Value("${coach.spring.name}")
    private String name;

    //autowiring with qualifier, using the constructor
    @Autowired
    public SpringCoach(@Qualifier("randomFortuneService") FortuneService fortuneService, @Value("${coach.spring.name}") String name) {
        this.fortuneService = fortuneService;
        this.name = name;
    }

    @Override
    public String getDailyWorkout() {
        return "Spring Coach: practice Spring 25 hour's every day!";
    }

    @Override
    public String getDailyFortune() {
        return "Spring Coach: " + fortuneService.getFortune();
    }

    @Override
    public String getName() {
        return name;
    }
}
