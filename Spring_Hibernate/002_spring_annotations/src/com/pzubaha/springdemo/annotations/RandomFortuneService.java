package com.pzubaha.springdemo.annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

//Add class for testing @Qualifier
@Component
public class RandomFortuneService implements FortuneService {

    // create an array of strings
    private String[] data ={
            "Beware of the wolf in sheeps clothing",
            "Diligence is mother of good luck",
            "the journey is the reward"
    };
    //create a random generator
    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        return data[myRandom.nextInt(3)];
    }
}
