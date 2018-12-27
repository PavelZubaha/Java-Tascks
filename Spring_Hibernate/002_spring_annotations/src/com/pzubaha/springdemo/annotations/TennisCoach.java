package com.pzubaha.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


//use annotation Component
@Component
@Scope("prototype")
public class TennisCoach implements Coach {

    @Value("${coach.tennis.name}")
    private String name;

    @PostConstruct
    private void init() {
        //
        System.out.println("Tennis coach: inside init() @PostConstruct");
    }

    //change bean to another impl of fortune service
    //which should load array of fortunes from file.
    @Autowired
    @Qualifier("fileStoredFortuneService")
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

    // when we use prototype scope
    // pre destroy will not be called by Spring
    @PreDestroy
    public void preDestroy() {
        System.out.println("Tennis coach: inside pre destroy method!");
    }
}
