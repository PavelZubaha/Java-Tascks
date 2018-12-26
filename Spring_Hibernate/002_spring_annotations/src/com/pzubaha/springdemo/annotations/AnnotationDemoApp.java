package com.pzubaha.springdemo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        //read spring cfg file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get beans from spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach springCoach = context.getBean("springCoach", Coach.class);

        //use returned bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(springCoach.getDailyWorkout());

        //use new method that needs autowired FortuneService's
        System.out.println(coach.getDailyFortune());
        System.out.println(springCoach.getDailyFortune());

        //difference
        System.out.println("coach == springCoach " + (coach == springCoach));

        //retrieve name's and use
        System.out.println(coach.getName() + " just meet friend " + springCoach.getName());

        //close container
        context.close();
    }
}
