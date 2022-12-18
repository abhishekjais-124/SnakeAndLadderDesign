package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] board;
    int size;

    public Board(int size, int noOfSnakes, int noOfLadders){
        this.size = size;
        initializeBoard(noOfLadders, noOfSnakes);
    }

    private void initializeBoard(int noOfLadders, int noOfSnakes) {
        board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }

        initializeJumps(noOfSnakes, noOfLadders);

    }

    private void initializeJumps(int noOfSnakes,int noOfLadders) {

        while (noOfLadders > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, this.size * this.size);
            int end = ThreadLocalRandom.current().nextInt(1, this.size * this.size - 1);

            if (start >= end){
                continue;
            }

            Jump jump = new Jump(start, end);
            Cell cell = getCell(start);
            cell.jump = jump;
            noOfLadders--;

        }

        while (noOfSnakes > 0) {
            int end = ThreadLocalRandom.current().nextInt(1, this.size * this.size);
            int start = ThreadLocalRandom.current().nextInt(1, this.size * this.size - 1);

            if (end >= start){
                continue;
            }

            Jump jump = new Jump(start, end);
            Cell cell = getCell(start);
            cell.jump = jump;
            noOfSnakes--;

         }
    }

    Cell getCell(int position){
        int row = position/size;
        int col = position%size;
        return board[row][col];

    }

}

