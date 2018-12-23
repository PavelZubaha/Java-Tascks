package com.pzubaha.springdemo;


public class MyApp {
    public static void main(String[] args) {
        //create object

//        BaseballCoach baseballCoach = new BaseballCoach();
        Coach coach = new TrackCoach();


        //use object
        System.out.println(coach.getDailyWorkout());
    }
}
