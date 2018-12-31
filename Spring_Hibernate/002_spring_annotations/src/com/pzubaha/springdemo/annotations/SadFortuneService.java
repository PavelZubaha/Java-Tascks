package com.pzubaha.springdemo.annotations;

public class SadFortuneService implements FortuneService {
  @Override
  public String getFortune() {
    return "The fortune today is GRAY SAD Day!";
  }
}
