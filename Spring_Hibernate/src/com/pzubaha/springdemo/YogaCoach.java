package com.pzubaha.springdemo;

public class YogaCoach implements Coach {
    //define field for injection
    private String email;

    //define another field
    private String city;

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
    //create setters for injection
    public void setEmail(String email) {
        System.out.println("Java coach: setter email! " + email);
        this.email = email;
    }

    //create setter for injection
    public void setCity(String city) {
        System.out.println("Java coach: set city! " + city);
        this.city = city;
    }

    public String getCity() {
        System.out.println("");
        return city;
    }

    public String getEmail() {
        return email;
    }
}
