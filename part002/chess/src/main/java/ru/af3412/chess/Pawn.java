package ru.af3412.chess;

/**
 * The type Pawn.
 *
 * @author Filatov Alexander
 * @since 01.09.2016
 */
public class Pawn extends Figure {

    @Override
    public String toString() {
        return "P";
    }

    /**
     *
     * @param board this board (array figures)
     * @param startVer logic vertical position
     * @param startHor logic horizontal position
     * @param endVer end vertical position
     * @param endHor end horizontal position
     * @return true or false check can move figures
     */
    @Override
    boolean move(Figure[][] board, int startHor, int startVer, int endHor, int endVer) {
        boolean canMove = false;
        if ((startHor - endHor) != 0) {
            canMove = false;
        }
        else if (Math.abs(startVer - endVer) > 2) {
            canMove = false;
        }
        else if (!inBound(endVer, endHor)){
            canMove = false;
        }
        else if (!isFreeCell(board, startVer, endVer, startHor)){
            canMove = false;
        }
        else {
            canMove = true;
        }

        return canMove;
    }

    /**
     * check boundary table
     *
     * @param ver is vertical position
     * @param hor is horizontal position
     * @return true or false of boundary table
     */
    boolean inBound(int ver, int hor) {
        return  (ver < 8 && hor < 8);
    }

    /**
     * check FreeCell
     *
     * @param board    this board
     * @param startVer is started vertical position
     * @param endVer   is ended position
     * @param hor      is horizontal line
     * @return true or false checkfree cell
     */
    boolean isFreeCell(Figure[][] board, int startVer, int endVer, int hor) {
        boolean isFree = false;
        for (int count = startVer+1; count <= endVer; count++) {
            if (board[hor][count] != null) {
                isFree = false;
                break;
            }
            else isFree = true;
        }
        return isFree;
    }


}
