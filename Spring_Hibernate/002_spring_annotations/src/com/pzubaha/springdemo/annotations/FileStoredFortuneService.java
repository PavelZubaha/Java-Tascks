package com.pzubaha.springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component()
public class FileStoredFortuneService implements FortuneService {
  private List<String> fortunes;
  private Path path;

  @PostConstruct
  public void init() {
    System.out.println("Init (@PostConstruct) File stored fortune service");
    try {
      fortunes = Files.readAllLines(path);
    } catch (IOException e) {
      System.out.println("There is some exception");
      e.printStackTrace();
    }
  }

  @Autowired
  public FileStoredFortuneService(@Value("${fortune.path}") String thePath) {
    System.out.println("<< in constructor FileStoredFortuneService with path:" + thePath);
    path = Paths.get(thePath);
  }


  @Override
  public String getFortune() {
    return fortunes.get((int) (Math.random() * fortunes.size()));
  }

  @PreDestroy
  public void preDestroy(){
    System.out.println("FILE STORED FORTUNE SERVICE: @PreDestroy");
  }
}
