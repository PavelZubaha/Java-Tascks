package com.pzubaha.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {
        //load context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-appConfig.xml");
        Coach yogaCoach = context.getBean("yogaCoach", YogaCoach.class);

        //work with instance
        System.out.println(yogaCoach.getDailyFortune());
        System.out.println(yogaCoach.getDailyWorkout());
    }


}
