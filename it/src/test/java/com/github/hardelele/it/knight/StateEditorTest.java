package com.github.hardelele.it.knight;

import org.junit.jupiter.api.Test;

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

        x+=1;
        y+=2;

        stateEditor.moveKnight(board, x, y);
        stateEditor.printBoard(board);
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
    }
}
