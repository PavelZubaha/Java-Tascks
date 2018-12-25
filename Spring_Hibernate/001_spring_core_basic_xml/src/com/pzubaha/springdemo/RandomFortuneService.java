package com.pzubaha.springdemo;

import static java.lang.Math.*;

public class RandomFortuneService implements FortuneService {
    private String[] fortune = {
            "This is best day!",
            "It's a peaceful day",
            "Exciting day! Blissful day",
            "Joyful day!"
    };
    @Override
    public String getFortune() {
        return fortune[(int) round(random() * 3)];
    }
}
