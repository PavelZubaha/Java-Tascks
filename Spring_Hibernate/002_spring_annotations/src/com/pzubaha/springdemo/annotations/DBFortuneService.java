package com.pzubaha.springdemo.annotations;

import org.springframework.stereotype.Component;

//Add class for testing @Qualifier annotation
@Component
public class DBFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }
}
