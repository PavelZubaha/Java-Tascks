package com.pzubaha.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //load cfg

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean
        Coach coach = context.getBean("coach", Coach.class);

        //call method
        System.out.println(coach.getDailyFortune());

        System.out.println(coach.getDailyWorkout());

        //create new class Yoga coach
        //instantiate it, set dependency in applicationContext.xml
        Coach yogaCoach = context.getBean("yogaCoach", Coach.class);

        //use new instance
        System.out.println(yogaCoach.getDailyWorkout());
        System.out.println(yogaCoach.getDailyFortune());

        //close context
        context.close();
    }
}
