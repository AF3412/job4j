package ru.af3412.chess;

/**
 * This class manages the figures on board
 *
 * @author Filatov Alexander
 *
 * @since 02.08.2016
 */
public class Controller {

    private Board board;

    public Controller(Board board) {
        this.board = board;
    }

    /**
     * Method initializes start position on board
     * Figure name:
     * P - Pawn; C - Bishop; N - kNight
     * R - Rook; * Q - Queen; K - King
     */
    public void initBoard() {
        for (int horizontal = 0; horizontal < board.size; horizontal++) {
            board.addFigure(horizontal, 1, new Figure("P"));
        }
        board.addFigure(0, 0, (new Figure("R")));
        board.addFigure(7, 0, (new Figure("R")));
        board.addFigure(1, 0, (new Figure("N")));
        board.addFigure(6, 0, (new Figure("N")));
        board.addFigure(2, 0, (new Figure("C")));
        board.addFigure(5, 0, (new Figure("C")));
        board.addFigure(4, 0, (new Figure("K")));
        board.addFigure(3, 0, (new Figure("Q")));

    }

    public void movePawn(int oldHor, int oldVer, int newHor, int newVer) {
        Figure moveFigure = board.getFigure(oldHor, oldVer);
        if ((newVer - oldVer) > 1) {
            System.out.println("Impossible");
        }
        else {
            board.addFigure(newHor, newVer, moveFigure);
            board.removeFigure(oldHor, oldVer);
        }

    }



}
