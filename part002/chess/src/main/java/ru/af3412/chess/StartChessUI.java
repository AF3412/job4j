package ru.af3412.chess;

/**
 * @author Filatov Alexander
 *
 * @since 02.08.2016
 */

public class StartChessUI {

    public static void main(String[] args) {



        Board board = new Board();

        Controller controller = new Controller(board);

        controller.initBoard();

        board.printBoard();

        controller.movePawn(3, 1, 3, 2);
        controller.movePawn(2, 1, 3, 3);

        board.printBoard();

    }




}
