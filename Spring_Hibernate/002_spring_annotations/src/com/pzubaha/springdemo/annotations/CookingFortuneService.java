package com.pzubaha.springdemo.annotations;

public class CookingFortuneService implements FortuneService {
  @Override
  public String getFortune() {
    return "It is a good day for cooking!";
  }
}
