package com.pzubaha.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//use annotation Component
@Component
public class TennisCoach implements Coach {

    @Value("${coach.tennis.name}")
    private String name;

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }


    // Add default constructor.
    // Just for my own benefits, for tracing
    public TennisCoach() {
        System.out.println("Tenis Coach default constructor");
    }
/*
    //add setter
    //Tell spring that should autowired dependency through this setter.
    //add some diagnostic message
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("TennisCoach << FortuneService SET!");
        this.fortuneService = fortuneService;
    }
*/
/*
    @Autowired
    public void doSomeCrazy(FortuneService fortuneService) {
        fortuneService.getFortune();
        System.out.println("Tennis coach: DO SOME CRAZY!");
    }
*/
    @Override
    public String getDailyWorkout() {
        return "Tennis Coach: Practice your backhand valley 15 min";
    }
    @Override
    public String getDailyFortune() {
        return "Tennis Coach: " + fortuneService.getFortune();
    }

    @Override
    public String getName() {
        return name;
    }
}
