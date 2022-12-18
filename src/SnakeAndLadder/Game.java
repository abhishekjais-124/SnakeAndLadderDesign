package SnakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    Board board;
    Dice dice;
    Queue<Player> players = new LinkedList<>();
    int boardSize;

    public Game(int boardSize, int noOfSnakes, int noOfLadders){
        this.boardSize = boardSize;
        initialzeGame(noOfLadders, noOfSnakes);
    }

    private void initialzeGame(int noOfLadders, int noOfSnakes) {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        players.add(player1);
        players.add(player2);

        board = new Board(boardSize, noOfSnakes, noOfLadders);
        dice = new Dice(1);
    }

    public void startGame(){

        Player winner = null;
        while (winner == null){
            Player currentPlayer = getNextPlayer();
            int diceValue = dice.rollDice();
            int currentpos = currentPlayer.getCurrentPos();
            int newPosition = findNewPosition(currentpos,diceValue);
            System.out.println(currentPlayer.name + " rolled dice and got value = "+ diceValue+" and moved from "+ currentpos+ " to newPosition " + newPosition);
            currentPlayer.setCurrentPos(newPosition);
            if(newPosition >= boardSize*boardSize) winner = currentPlayer;
        }

        System.out.println("Winner is "+ winner.name);
    }

    private int findNewPosition(int currentpos, int diceValue) {
        int newPosition = currentpos + diceValue;
        if (newPosition >= boardSize*boardSize){
            return newPosition;
        }
        Cell currentCell = board.getCell(newPosition);
        if (currentCell.getJump() != null && currentCell.getJump().start == newPosition){
            newPosition = currentCell.getJump().end;
            if ( currentCell.getJump().start < currentCell.getJump().end) System.out.println("Found ladder and moved to "+ newPosition);
            else System.out.println("Caught by snake and moved to "+ newPosition);
        }
        return newPosition;
    }

    private Player getNextPlayer() {
        Player current = players.remove();
        players.add(current);
        return current;
    }

}
