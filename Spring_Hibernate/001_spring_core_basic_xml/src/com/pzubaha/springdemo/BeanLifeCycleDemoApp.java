package com.pzubaha.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {
        //load context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-appConfig.xml");
        Coach yogaCoach = context.getBean("yogaCoach", Coach.class);
        Coach prototypeYogaCoach = context.getBean("prototypeYogaCoach", Coach.class);


        //work with instance(singleton)
        System.out.println(yogaCoach.getDailyFortune());
        System.out.println(yogaCoach.getDailyWorkout());

        //work with another instance(prototype)
        System.out.println(prototypeYogaCoach.getDailyWorkout());
        System.out.println(prototypeYogaCoach.getDailyFortune());

        //compare beans
        System.out.println("Are beans refer to single instance: " + (yogaCoach == prototypeYogaCoach));

        //
        System.out.println("Here should be destroy methods of this beans:");
        context.close();
    }


}
