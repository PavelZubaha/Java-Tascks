package com.pzubaha.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
  public static void main(String[] args) {
    //read configuration
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(Configuration.class);

    //Get bean
    Coach coach = context.getBean("tennisCoach", Coach.class);
    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getDailyFortune());

    //close context
    context.close();
  }
}
