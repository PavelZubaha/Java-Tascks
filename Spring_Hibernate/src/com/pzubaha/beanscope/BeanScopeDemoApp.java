package com.pzubaha.beanscope;

import com.pzubaha.springdemo.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        //load spring cfg
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-spring_cfg.xml");

        //retrieve bean from container
        Coach theCoach = context.getBean("coach", Coach.class);
        Coach alphaCoach = context.getBean("coach", Coach.class);

        //compare references
        System.out.println("Is the coach and alphaCoach references the same: " + (theCoach == alphaCoach));

        //memory location of retrieved objects
        System.out.println("Memory location theCoach: " + theCoach);
        System.out.println("Memory location alphaCoach" + alphaCoach);

        context.close();
    }



}
