package com.github.hardelele.it.knight;

import java.util.ArrayList;

public class StateEditor {

    private final int boardSize = 8;
    private final int knight = 1;
    private final int emptySquare = 0;
    private final int usedSquare = 2;

    private int knightX, knightY;

    public StateEditor() {

    }

    public void initializeBoardAsEmpty(int[][] board, int boardSize) {
        for (int counterX = 0; counterX < boardSize; counterX++) {
            board[counterX] = new int[boardSize];
            for (int counterY = 0; counterY < boardSize; counterY++) {
                board[counterX][counterY] = emptySquare;
            }
        }
    }

    public void putKnight(int[][] board, int x, int y) {
        if(isPossibleToPut(board, x, y)){
            knightX = x;
            knightY = y;
            board[knightX][knightY] = knight;
        }
    }

    public void printBoard(int[][] board) {
        System.out.print("\n");
        for (int counterY = 0; counterY < boardSize; counterY++) {
            for (int counterX = 0; counterX < boardSize; counterX++) {
                System.out.print(board[counterX][counterY] + " ");
            }
            System.out.print("\n");
        }
    }

    public boolean isPossibleToPut(int[][] board, int x, int y) {
        if ((x >= 0) && (x < 8) && (y >= 0) && (y < 8)) {
            return (board[x][y] == 0);
        }
        else {
            return false;
        }
    }

    public boolean isPossibleToMove(int[][] board, int x, int y) {
        int differenceX = Math.abs(knightX - x);
        int differenceY = Math.abs(knightY - y);
            return isPossibleToPut(board, x, y)
                    && ((differenceX + differenceY==3) && (differenceX == 1 || differenceY == 1));
    }

    public void moveKnight(int[][] board, int x, int y) {
        if(isPossibleToMove(board, x, y)) {
            board[knightX][knightY] = usedSquare;
            knightX = x;
            knightY = y;
            board[knightX][knightY] = knight;
        }
    }

    public void rightHorizontalRound(int[][] board, int x, int y) {
        for (int counterX = x; counterX < 8; counterX++) {
            for (int counterY = y-1; counterY <= y+1; counterY++) {
                moveKnight(board,counterX,counterY);
            }
        }
    }

    public void leftHorizontalRound(int[][] board, int x, int y) {
        for (int counterX = x; counterX >= 0; counterX--) {
            for (int counterY = y-1; counterY <= y+1; counterY++) {
                moveKnight(board,counterX,counterY);
            }
        }
    }
}
