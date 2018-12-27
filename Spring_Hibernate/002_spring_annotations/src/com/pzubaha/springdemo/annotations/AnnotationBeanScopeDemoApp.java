package com.pzubaha.springdemo.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
  public static void main(String[] args) {

    // load cfg
    ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from spring container
    Coach theCoach = context.getBean("tennisCoach", Coach.class);

    Coach alphaCoach = context.getBean("tennisCoach", Coach.class);


    // check if the references are the same
    boolean result = theCoach == alphaCoach;

    if (result) {
      System.out.println("There is used singleton");
    } else {
      System.out.println("There is used prototype");
    }

    //print results
    System.out.printf("%nPointing to the same object: %s%n", result);

    System.out.printf("%nMemory location of theCoach: %s%n%n location of alphaCoach: %s%n", theCoach, alphaCoach);

    context.close();
  }
}
