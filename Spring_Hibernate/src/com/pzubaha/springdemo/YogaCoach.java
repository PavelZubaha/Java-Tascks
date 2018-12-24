package com.pzubaha.springdemo;

public class YogaCoach implements Coach {
    private FortuneService fortuneService;

    public YogaCoach() {
        System.out.println("Yoga coach: no-argument constructor!");
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Yoga Coach: Lets practice yoga poses and meditation!";
    }

    @Override
    public String getDailyFortune() {
        return "Yoga Coach: OM! "+ fortuneService.getFortune();
    }
}
