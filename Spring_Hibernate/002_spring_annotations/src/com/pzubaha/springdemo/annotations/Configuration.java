package com.pzubaha.springdemo.annotations;

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
  public SwimCoach swimCoach() {
    return new SwimCoach(sadFortuneService());
  }

}
