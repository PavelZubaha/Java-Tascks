package com.pzubaha.springdemo.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:cook.properties")
public class CookConfiguration {

  @Bean
  public FortuneService fortuneService() {
    return new CookingFortuneService();
  }

  @Bean
  @Scope(value = "")
  public Coach cookCoach(@Value("${coach.cook.name}") String name) {
    return new CookingCoach(fortuneService(), name);
  }

}
