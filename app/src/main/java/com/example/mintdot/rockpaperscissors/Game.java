package com.example.mintdot.rockpaperscissors;

import java.util.Random;

public class Game {
    Random rnd;
    int pNum;
    int cNum;

    public Game(int p) {
        rnd = new Random();
        pNum = p;
    }

    public int computer() {
        cNum = rnd.nextInt(3);

        return cNum;
    }

    public int compare(int cNum) {

        switch (pNum) {
            case 0: // 바위
                if (cNum == 1) { // 바위 vs. 보
                    return 2;
                } else if (cNum == 2) { // 바위 vs. 가위-
                    return 1;
                }
                break;
            case 1: // 보
                if (cNum == 0) { // 보 vs. 바위
                    return 1;
                } else if (cNum == 2) { // 보 vs. 가위
                    return 2;
                }
                break;
            case 2: // 가위
                if (cNum == 0) { // 가위 vs. 바위
                    return 2;
                } else if (cNum == 1) { // 가위 vs. 보
                    return 1;
                }
                break;
        }
        return 0;
    }

}
