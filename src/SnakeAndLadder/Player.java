package SnakeAndLadder;

public class Player {

    int currentPos;
    String name;

    public Player(String name){
        this.name = name;
        currentPos = 0;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }
}
