package com.example.mintdot.rockpaperscissors;

import java.util.Random;

public class Game {
    private Random rnd;
    private int pNum;
    private int cNum;

    public Game(int p) {
        rnd = new Random();
        pNum = p;
    }

    public int computer() {
        cNum = rnd.nextInt(3);

        return cNum;
    }

    public int compare(int cNum) {
        if (pNum - cNum == -2 || pNum - cNum == 1) {
            return 1;
        } else if (pNum - cNum == -1 || pNum - cNum == 2) {
            return 2;
        }

        return 0;
    }

}
