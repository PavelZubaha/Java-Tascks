package com.pzubaha.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

  public static void main(String[] args) {
    //Create contex
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(Configuration.class);


    //retrieve the beans
    Coach coach = context.getBean("swimCoach", Coach.class);

    //use bean
    System.out.println(coach.getDailyFortune());

    //close context
    context.close();
  }
}
