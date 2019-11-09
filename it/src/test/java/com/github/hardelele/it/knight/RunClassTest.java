package com.github.hardelele.it.knight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunClassTest {

    RunClass runClass = new RunClass();

    @Test
    public void initializeEmptyBoardTest() {
        int boardSize = 8;
        int[][] board = new int[boardSize][];
        runClass.initializeBoardAsEmpty(board,boardSize);
        for (int counterX = 0; counterX < boardSize; counterX++) {
            for (int counterY = 0; counterY < boardSize; counterY++) {
                System.out.println("X = "+ counterX + " Y = " + counterY + " square = " + board[counterX][counterY]);
            }
        }
        runClass.printBoard(board);
    }

    @Test
    public void putKnightTest() {
        int knightX = 1;
        int knightY = 2;
        int boardSize = 8;
        int[][] board = new int[boardSize][];
        runClass.initializeBoardAsEmpty(board,boardSize);
        runClass.putKnight(board, knightX, knightY);

        for (int counterX = 0; counterX < boardSize; counterX++) {
            for (int counterY = 0; counterY < boardSize; counterY++) {
                System.out.println("X = "+ counterX + " Y = " + counterY + " square = " + board[counterX][counterY]);
            }
        }

        System.out.print("\n");
        for (int counterY = 0; counterY < boardSize; counterY++) {
            for (int counterX = 0; counterX < boardSize; counterX++) {
                System.out.print("x" + counterX + "y" + counterY + "=" + board[counterX][counterY] + " ");
            }
            System.out.print("\n");
        }
    }
}
