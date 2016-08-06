package ru.af3412.chess;

/**
 *
 * This class contains an array of chess pieces
 * and displays their location on the screen
 *
 * @author Filatov Alexander
 *
 * @since 02.08.2016
 *
*/

public class Board {

    protected final int size = 8;

    protected Figure[][] chessBoard = new Figure[size][size];

    protected void addFigure(int horizontal, int vertical, Figure figure) {
        chessBoard[horizontal][vertical] = figure;
    }

    protected void removeFigure(int horizontal, int vertical) {
        chessBoard[horizontal][vertical] = null;
    }

    protected Figure getFigure(int horizontal, int vertical) {
        return chessBoard[horizontal][vertical];
    }

    protected void printBoard() {
        for(int countVertical = 0; countVertical < 8; countVertical++) {
            for(int countHorizontal = 0; countHorizontal < 8; countHorizontal++){
                if (chessBoard[countHorizontal][countVertical] == null) {
                    System.out.print("\t0");
                }
                else {
                    System.out.print("\t" + chessBoard[countHorizontal][countVertical].getName());
                }
            }
            System.out.println();
        }
        System.out.println();
    }


}
