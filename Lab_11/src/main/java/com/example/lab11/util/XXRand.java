package com.example.lab11.util;

import java.util.Random;

public class XXRand {
    private Integer n = Integer.MAX_VALUE;
    private Random random = new Random();

    public XXRand(Integer n) {
        if (n > 0)
            this.n = n;
    }

    public Integer Get() {
        return (random.nextInt()%this.n);
    }
}
