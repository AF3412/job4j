package ru.af3412.chess;

/**
 * @author Filatov Alexander
 * @since 23.08.2016
 */
public class Board {

    public Cell[][] board = new Cell[8][8];

    public void createBoard() {
        for (int cVer = 0; cVer < 8; cVer++) {
            for (int cHor = 0; cHor < 8; cHor++) {
                board[cVer][cHor] = new Cell(cVer, cHor);
            }
        }
    }


    protected void printBoard() {
        for(int countVertical = 0; countVertical < 8; countVertical++) {
            for(int countHorizontal = 0; countHorizontal < 8; countHorizontal++){

                if (board[countHorizontal][countVertical].getIsFree() == true){
                    System.out.print("\tO");
                }
                else {
                    System.out.print("\t" + board[countHorizontal][countVertical].nameFigure);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /*public void moveFigure(Cell start, Cell distance) {
        start.

    }*/


}
