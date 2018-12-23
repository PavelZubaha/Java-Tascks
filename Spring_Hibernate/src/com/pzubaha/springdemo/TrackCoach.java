package com.pzubaha.springdemo;

public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
