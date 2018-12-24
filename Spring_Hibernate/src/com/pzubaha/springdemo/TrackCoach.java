package com.pzubaha.springdemo;

public class TrackCoach implements Coach {

    FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Track coach: Run hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Track coach: Just DO IT! " + fortuneService.getFortune();
    }
}
