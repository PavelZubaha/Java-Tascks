package com.pzubaha.springdemo.annotations;

import org.springframework.stereotype.Component;


//use annotation Component
@Component("theSillyCoach")
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand valley";
    }
}
