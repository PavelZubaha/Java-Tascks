package com.pzubaha.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //load cfg

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean
        Coach coach = context.getBean("coach", Coach.class);

        //call methods

        System.out.println(coach.getDailyWorkout());

        //close context
        context.close();
    }
}
