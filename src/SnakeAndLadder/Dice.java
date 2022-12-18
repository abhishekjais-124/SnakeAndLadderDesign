package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int noOfDices;

    public Dice(int noOfDices){
        this.noOfDices= noOfDices;
    }

    public int rollDice(){
        int tot = 0;
        int max =6;
        int min = 1;
        int diceCount = noOfDices;
        while (diceCount-- > 0){
            tot += ThreadLocalRandom.current().nextInt(min,max+1);
        }
        return tot;
    }

}