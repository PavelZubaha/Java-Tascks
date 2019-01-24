package com.pzubaha.springdemo.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CookingCoach implements Coach {

  private FortuneService fortuneService;
  private String name;

  public CookingCoach(FortuneService fortuneService, String name) {
    this.fortuneService = fortuneService;
    this.name = name;
  }

  @PostConstruct
  public void init(){
    System.out.println(name + ": post construct!");
  }

  @PreDestroy
  public void predestroy() {
    System.out.println(name+ ": preDestroy method!");
  }

  @Override
  public String getDailyWorkout() {
    return name + ": Lets try to make sushi!";
  }

  @Override
  public String getDailyFortune() {
    return name + ": " + fortuneService.getFortune();
  }

  @Override
  public String getName() {
    return name;
  }
}
