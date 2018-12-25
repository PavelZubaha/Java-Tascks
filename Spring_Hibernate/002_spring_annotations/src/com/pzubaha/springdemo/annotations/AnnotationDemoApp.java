package com.pzubaha.springdemo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        //read spring cfg file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get bean from spring container
        Coach theSillyCoach = context.getBean("theSillyCoach", Coach.class);

        //use returned bean
        System.out.println(theSillyCoach.getDailyWorkout());

        //close container
        context.close();
    }
}
