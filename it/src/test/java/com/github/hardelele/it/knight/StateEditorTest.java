package com.github.hardelele.it.knight;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateEditorTest {

    StateEditor stateEditor = new StateEditor();

    @Test
    public void initializeEmptyBoardTest() {
        int boardSize = 8;
        int[][] board = new int[boardSize][];

        stateEditor.initializeBoardAsEmpty(board,boardSize);
        stateEditor.printBoard(board);
    }

    @Test
    public void putKnightTest() {
        int knightX = 1;
        int knightY = 2;
        int boardSize = 8;
        int[][] board = new int[boardSize][];

        stateEditor.initializeBoardAsEmpty(board,boardSize);
        stateEditor.putKnight(board, knightX, knightY);

        int assertion = 1;
        int actual = 0;
        for (int i = 0; i < 8; i++) {
            actual += IntStream.of(board[i]).sum();
        }

        assertEquals(assertion, actual);
    }

    @Test
    public void moveKnightTest() {
        int x = 0;
        int y = 0;
        int boardSize = 8;
        int[][] board = new int[boardSize][];

        stateEditor.initializeBoardAsEmpty(board,boardSize);
        stateEditor.putKnight(board, x, y);
        stateEditor.printBoard(board);

        x+=2;
        y+=1;

        stateEditor.moveKnight(board, x, y);
        stateEditor.printBoard(board);

        int assertionX = 2;
        int assertionY = 1;

        assertEquals(assertionX, x);
        assertEquals(assertionY, y);

        x+=1;
        y+=2;

        stateEditor.moveKnight(board, x, y);
        stateEditor.printBoard(board);

        assertionX = 3;
        assertionY = 3;

        assertEquals(assertionX, x);
        assertEquals(assertionY, y);
    }

    @Test
    public void rightHorizontalRoundTest() {
        int x = 0;
        int y = 0;
        int boardSize = 8;
        int[][] board = new int[boardSize][];

        stateEditor.initializeBoardAsEmpty(board,boardSize);
        stateEditor.putKnight(board, x, y);
        stateEditor.printBoard(board);

        stateEditor.rightHorizontalRound(board,x,y);
        stateEditor.printBoard(board);

        x = stateEditor.getKnightX();
        y = stateEditor.getKnightY();

        int assertionX = 6;
        int assertionY = 1;

        assertEquals(assertionX, x);
        assertEquals(assertionY, y);
    }

    @Test
    public void leftHorizontalRoundTest() {
        int x = 7;
        int y = 0;
        int boardSize = 8;
        int[][] board = new int[boardSize][];

        stateEditor.initializeBoardAsEmpty(board,boardSize);
        stateEditor.putKnight(board, x, y);
        stateEditor.printBoard(board);

        stateEditor.leftHorizontalRound(board,x,y);
        stateEditor.printBoard(board);

        x = stateEditor.getKnightX();
        y = stateEditor.getKnightY();

        int assertionX = 1;
        int assertionY = 1;

        assertEquals(assertionX, x);
        assertEquals(assertionY, y);
    }

    @Test
    public void bottomVerticalRoundTest() {
        int x = 0;
        int y = 0;
        int boardSize = 8;
        int[][] board = new int[boardSize][];

        stateEditor.initializeBoardAsEmpty(board,boardSize);
        stateEditor.putKnight(board, x, y);
        stateEditor.printBoard(board);

        stateEditor.bottomVerticalRound(board, x, y);
        stateEditor.printBoard(board);

        x = stateEditor.getKnightX();
        y = stateEditor.getKnightY();

        int assertionX = 1;
        int assertionY = 6;

        assertEquals(assertionX, x);
        assertEquals(assertionY, y);
    }

    @Test
    public void topVerticalRoundTest() {
        int x = 0;
        int y = 7;
        int boardSize = 8;
        int[][] board = new int[boardSize][];

        stateEditor.initializeBoardAsEmpty(board,boardSize);
        stateEditor.putKnight(board, x, y);
        stateEditor.printBoard(board);

        stateEditor.topVerticalRound(board, x, y);
        stateEditor.printBoard(board);

        x = stateEditor.getKnightX();
        y = stateEditor.getKnightY();

        int assertionX = 1;
        int assertionY = 1;

        assertEquals(assertionX, x);
        assertEquals(assertionY, y);
    }

    @Test
    public void test() {
        int x = 0;
        int y = 0;
        int boardSize = 8;
        int[][] board = new int[boardSize][];

        stateEditor.initializeBoardAsEmpty(board,boardSize);
        stateEditor.putKnight(board, x, y);
        stateEditor.printBoard(board);

        stateEditor.bottomVerticalRound(board, x, y);
        stateEditor.printBoard(board);

        x = stateEditor.getKnightX();
        y = stateEditor.getKnightY();

        int assertionX = 1;
        int assertionY = 6;

        assertEquals(assertionX, x);
        assertEquals(assertionY, y);
    }
}
