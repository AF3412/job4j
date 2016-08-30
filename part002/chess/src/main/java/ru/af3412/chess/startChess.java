package ru.af3412.chess;

/**
 * @author Filatov Alexander
 * @since 30.08.2016
 */
public class startChess {

    public static void main(String[] args) {

        Board chess = new Board();
        chess.createBoard();

        Pawn pawn1 = new Pawn(chess.board[1][1], true);

        chess.printBoard();





    }

}
