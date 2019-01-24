package com.pzubaha.springdemo.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CookingJavaCodeCfgDemoApp {
  public static void main(String[] args) {
    //load context and logger settings
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(LoggerConfig.class, CookConfiguration.class);

    //get bean
    Coach cookCoach = context.getBean("cookCoach", Coach.class);
    Coach cookCoach2 = context.getBean(Coach.class);

    //use bean
    System.out.println(cookCoach.getDailyFortune());
    System.out.println(cookCoach.getDailyWorkout());

    System.out.println("cookCoach == cookCoach: " + (cookCoach == cookCoach2));

    //close context
    context.close();
  }
}
