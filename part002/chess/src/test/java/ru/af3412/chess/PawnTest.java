package ru.af3412.chess;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Pawn test.
 *
 * @author Filatov Alexander
 * @since 03.09.2016
 */
public class PawnTest {

    /**
     * In bound test true.
     */
    @Test
    public void inBoundTestTrue() {

        Pawn pawn = new Pawn();

        boolean testInBound = pawn.inBound(0,0);

        assertTrue(testInBound);

    }

    /**
     * In bound test false.
     */
    @Test
    public void inBoundTestFalse() {

        Pawn pawn = new Pawn();

        boolean testInBound = pawn.inBound(8,0);

        assertFalse(testInBound);

    }

    /**
     * Is free cell true.
     */
    @Test
    public void isFreeCellTrue() {

        Pawn pawn = new Pawn();
        Figure[][] board = new Figure[8][8];
        board[3][3] = new Pawn();

        boolean testOneFreeCell = pawn.isFreeCell(board, 1, 2, 0);

        assertTrue(testOneFreeCell);

    }

    /**
     * Is free cell false.
     */
    @Test
    public void isFreeCellFalse() {

        Pawn pawn = new Pawn();
        Figure[][] board = new Figure[8][8];
        board[3][3] = new Pawn();

        boolean testTwoFreeCell = pawn.isFreeCell(board, 1, 3, 3);

        assertFalse(testTwoFreeCell);

    }

    /**
     * Is can move pawn true.
     */
    @Test
    public void isCanMovePawnTrue() {

        Pawn pawn = new Pawn();
        Figure[][] board = new Figure[8][8];

        boolean testCanMovePawn = pawn.move(board, 0, 1, 0, 2);

        assertTrue(testCanMovePawn);

    }

    /**
     * Is can move pawn false horizontal position.
     */
    @Test
    public void isCanMovePawnFalseHorizontalPosition() {

        Pawn pawn = new Pawn();
        Figure[][] board = new Figure[8][8];

        boolean testCanMovePawn = pawn.move(board, 0, 1, 1, 2);

        assertFalse(testCanMovePawn);

    }

    /**
     * Is can move pawn false more two move.
     */
    @Test
    public void isCanMovePawnFalseMoreTwoMove() {

        Pawn pawn = new Pawn();
        Figure[][] board = new Figure[8][8];

        boolean testCanMovePawn = pawn.move(board, 0, 1, 0, 4);

        assertFalse(testCanMovePawn);

    }

    /**
     * Is can move pawn false non free cell.
     */
    @Test
    public void isCanMovePawnFalseNonFreeCell() {

        Pawn pawn = new Pawn();
        Figure[][] board = new Figure[8][8];
        board[0][2] = new Pawn();

        boolean testCanMovePawn = pawn.move(board, 0, 1, 0, 3);

        assertFalse(testCanMovePawn);

    }

}