package com.github.hardelele.it.knight;

public class RunClass {

    private final int boardSize = 8;
    private final int knight = 1;
    private final int emptySquare = 0;
    private final int usedSquare = 4;

    private int moveX, moveY;
    private int knightX, knightY;

    private int[][] board;

    public RunClass() {
        initializeEmptyBoard();
        putKnight(0,0);
        printBoard();
        moveKnight(1,2);
        printBoard();
        makeHorizontalMoves(knightY);
        printBoard();
    }

    private void initializeEmptyBoard() {
        board = new int[boardSize][];
        for (int counterX = 0; counterX < boardSize; counterX++) {
            board[counterX] = new int[boardSize];
            for (int counterY = 0; counterY < boardSize; counterY++) {
                board[counterX][counterY] = emptySquare;
            }
        }
    }

    private void putKnight(int x, int y) {
        if(isPossibleToPut(x,y)){
            knightX = x;
            knightY = y;
            board[knightX][knightY] = knight;
        }
    }

    private void printBoard() {
        System.out.print("\n");
        for (int counterX = 0; counterX < boardSize; counterX++) {
            for (int counterY = 0; counterY < boardSize; counterY++) {
                System.out.print(board[counterX][counterY] + " ");
            }
            System.out.print("\n");
        }
    }

    private boolean isPossibleToPut(int x, int y) {
        return (board[x][y] == 0) && (x >= 0) && (x < 8) && (y >= 0) && (y < 8);
    }

    private boolean isPossibleToMove(int x, int y) {
        int differenceX = Math.abs(knightX - x);
        int differenceY = Math.abs(knightY - y);
            return isPossibleToPut(x, y) && ((differenceX + differenceY==3) && (differenceX == 1 || differenceY == 1));
    }

    private void moveKnight(int x, int y) {
        if(isPossibleToMove(x, y)){
            board[knightX][knightY] = usedSquare;
            knightX = x;
            knightY = y;
            board[knightX][knightY] = knight;
        }
    }

    private void makeHorizontalMoves(int y) {
        for (int counterX = 0; counterX < 8; counterX++) {
            for (int counterY = y-1; counterY < y+2; counterY += 2) {
                moveKnight(counterX, counterY);
            }
        }
    }
}
