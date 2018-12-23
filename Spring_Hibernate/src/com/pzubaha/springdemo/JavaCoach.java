package com.pzubaha.springdemo;

public class JavaCoach implements Coach {

    //define private for dependency
    private FortuneService fortuneService;

    //add constructor for dependency injection
    public JavaCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spring rules! You should learn Spring every day and avery night!";
    }

    //use added dependency
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
