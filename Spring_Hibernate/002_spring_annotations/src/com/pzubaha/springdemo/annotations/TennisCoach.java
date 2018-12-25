package com.pzubaha.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//use annotation Component
@Component
public class TennisCoach implements Coach {
    private FortuneService fortuneService;

    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis Coach: Practice your backhand valley 15 min";
    }
    @Override
    public String getDailyFortune() {
        return "Tennis Coach: " + fortuneService.getFortune();
    }
}
