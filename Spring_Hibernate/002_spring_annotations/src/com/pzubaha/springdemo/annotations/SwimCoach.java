package com.pzubaha.springdemo.annotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

  private FortuneService fortuneService;

  public SwimCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }


//  @Value("${coach.swim.name}")
  private String name;

  public SwimCoach(FortuneService sadFortuneService, String name) {
    this.fortuneService = sadFortuneService;
    this.name = name;
  }

  @Override
  public String getDailyWorkout() {
    return "Swim Coach: lets go swimming!";
  }

  @Override
  public String getDailyFortune() {
    return "Swim Coach: " +  fortuneService.getFortune();
  }

  @Override
  public String getName() {
    return name;
  }
}
