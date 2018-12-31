package com.pzubaha.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

  public static void main(String[] args) {
    //Create contex
    //add logger config class, add app config class
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(LoggerConfig.class, Configuration.class);


    //retrieve the beans
    Coach coach = context.getBean("swimCoach", Coach.class);

    //use bean
    System.out.println(coach.getName() + ": " + coach.getDailyFortune());

    //close context
    context.close();
  }
}
