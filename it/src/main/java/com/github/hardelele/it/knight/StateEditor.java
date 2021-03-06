package com.github.hardelele.it.knight;

import java.util.ArrayList;

public class StateEditor {

    private final int boardSize = 8;

    /**
     * Numbers that will be stored in board array.
     * 0 - empty square that never used
     * 1 - square that contains knight figure right now
     * 2 - empty square that was used for storing knight figure
     */
    private final int usedSquare = 2;
    private final int knight = 1;
    private final int emptySquare = 0;

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
        if(isOnBoard(board, x, y)){
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
        System.out.print("\n");
    }

    public boolean isOnBoard(int[][] board, int x, int y) {
        if ((x >= 0) && (x < 8) && (y >= 0) && (y < 8)) {
            return (board[x][y] == 0);
        }
        else {
            return false;
        }
    }

    public void printException(int[][] board, int x, int y) {
        if (!((x >= 0) && (x < 8) && (y >= 0) && (y < 8))) {
            System.err.println("Error! Cant put figure: out of board border on [x=" + x +"; y=" + y + "]");
        } else if(!(board[x][y] == 0)) {
            System.err.println("Error! Cant put figure: there is already used square [x=" + x +"; y=" + y + "]");
        }
    }

    public boolean isPossibleToMove(int[][] board, int x, int y) {
        int differenceX = Math.abs(knightX - x);
        int differenceY = Math.abs(knightY - y);
            return isOnBoard(board, x, y)
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

    public void moveKnightOrPrintException(int[][] board, int x, int y) {
        moveKnight(board, x, y);
        printException(board, x, y);
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

    public void bottomVerticalRound(int[][] board, int x, int y) {
        for (int counterY = y; counterY < 8; counterY++) {
            for (int counterX = x-1; counterX <= x+1; counterX++) {
                moveKnight(board,counterX,counterY);
            }
        }
    }

    public void topVerticalRound(int[][] board, int x, int y) {
        for (int counterY = y; counterY >= 0; counterY--) {
            for (int counterX = x-1; counterX <= x+1; counterX++) {
                moveKnight(board,counterX,counterY);
            }
        }
    }

    public void topLeftMove(int[][] board, int x, int y) {
        moveKnightOrPrintException(board, x - 1, y - 2);
    }

    public void topRightMove(int[][] board, int x, int y) {
        moveKnightOrPrintException(board, x + 1, y - 2);
    }

    public void bottomLeftMove(int[][] board, int x, int y) {
        moveKnightOrPrintException(board, x - 1, y + 2);
    }

    public void bottomRightMove(int[][] board, int x, int y) {
        moveKnightOrPrintException(board, x + 1, y + 2);
    }

    public void leftTopMove(int[][] board, int x, int y) {
        moveKnightOrPrintException(board, x - 2, y - 1);
    }

    public void leftBottomMove(int[][] board, int x, int y) {
        moveKnightOrPrintException(board, x - 2, y + 1);
    }

    public void rightTopMove(int[][] board, int x, int y) {
        moveKnightOrPrintException(board, x + 2, y - 1);
    }

    public void rightBottomMove(int[][] board, int x, int y) {
        moveKnightOrPrintException(board, x + 2, y + 1);
    }


    /*
    Getters and Setters
     */

    public int getKnightX() {
        return knightX;
    }

    public int getKnightY() {
        return knightY;
    }
}
