package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    @Test
    public void testKnight() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("WHITE Knight", new Knight(PieceType.KNIGHT, Player.WHITE, testCoords).toString());
    }

    @Test
    public void testKnightSymbol() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("KNIGHT", new Knight(PieceType.KNIGHT, Player.WHITE, testCoords).getSymbol());
    }

    @Test
    public void testRookMove() {
        Chessboard board = new Chessboard();
        String moveFrom = "a3";
        String moveTo= "b5";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);
        assertEquals(true, new Knight(PieceType.KNIGHT, Player.WHITE, testCoords).canMove(board, testCoords2));

        String moveTo2= "a5";
        Coordinates testCoords22 = new Coordinates(moveTo2);
        assertEquals(false, new Knight(PieceType.KNIGHT, Player.WHITE, testCoords).canMove(board, testCoords22));

        //Try stepping on a tile with a friendly piece on
        String pieceBlock= "b5";
        Coordinates blockCoords = new Coordinates(pieceBlock);
        ChessPiece testPiece = new Knight(PieceType.KNIGHT, Player.BLACK, blockCoords);
        board.addPiece(testPiece);
        assertEquals(false, new Knight(PieceType.KNIGHT, Player.BLACK, testCoords).canMove(board, blockCoords));

    }

}
