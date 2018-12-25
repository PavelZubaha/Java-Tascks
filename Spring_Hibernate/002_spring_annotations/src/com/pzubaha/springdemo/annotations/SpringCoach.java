package com.pzubaha.springdemo.annotations;

import org.springframework.stereotype.Component;

@Component
public class SpringCoach implements Coach {
    private FortuneService fortuneService;

    //comment annotation but sill work.
    //if only one constructor @autowired is optional.
    //@Autowired
    public SpringCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spring Coach: practice Spring 25 hour's every day!";
    }

    @Override
    public String getDailyFortune() {
        return "Spring Coach: " + fortuneService.getFortune();
    }
}
