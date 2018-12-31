package com.pzubaha.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@org.springframework.context.annotation.Configuration

//@ComponentScan("com.pzubaha.springdemo.annotations")
@PropertySource("classpath:sport.properties")
public class Configuration {

  //define bean for sad fortune service
  @Bean
  public FortuneService sadFortuneService() {
    return new SadFortuneService();
  }

  //define dean for swim coach
  //AND inject dependency!
  @Bean
  public SwimCoach swimCoach(@Value("${coach.swim.name}") String name) {
    return new SwimCoach(sadFortuneService(), name);
  }
}
