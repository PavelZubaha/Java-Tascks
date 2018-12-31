package com.pzubaha.springdemo.annotations;

public class SwimCoach implements Coach {

  private FortuneService fortuneService;

  private String name;

  public SwimCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
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
