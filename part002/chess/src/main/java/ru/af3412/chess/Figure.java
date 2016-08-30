package ru.af3412.chess;

/**
 * @author Filatov Alexander
 * @since 23.08.2016
 */
public abstract class Figure {

    /**
     * Figure color
     * white color true
     * black color false
     */
    boolean color;

    Cell cell;

    //Board chessBoard;

    public Figure(Cell cell, boolean color) {
      //  this.chessBoard = chessBoard;
        this.cell = cell;
        this.color = color;
    }

   // abstract Cell[] move(Cell distance);

}
