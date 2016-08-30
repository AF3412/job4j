package ru.af3412.chess;

/**
 * @author Filatov Alexander
 * @since 25.08.2016
 */
public class Pawn extends Figure {

    public Pawn(Cell cell, boolean color) {
        super(cell, color);
        cell.setIsFree(false);
        cell.nameFigure = "P";
    }







}

