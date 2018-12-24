package com.pzubaha.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext("applicationContext.xml");
        YogaCoach coach = cpxac.getBean("yogaCoach", YogaCoach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyFortune());
        System.out.println("Send me mail to:" + coach.getEmail());
        System.out.println("Or visit me on: " + coach.getCity());
        cpxac.close();
    }
}
