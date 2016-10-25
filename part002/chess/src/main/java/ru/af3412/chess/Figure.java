package ru.af3412.chess;

/**
 * The type Figure.
 *
 * @author Filatov Alexander
 * @since 31.08.2016
 */
public abstract class Figure {


    /**
     * Move boolean.
     *
     * @param board    this board (array figures)
     * @param startVer start vertical position
     * @param startHor start horizontal position
     * @param endVer   end vertical position
     * @param endHor   end horizontal position
     * @return true or false can move figures
     */
    abstract boolean move(Figure board[][], int startVer, int startHor, int endVer, int endHor);

}
