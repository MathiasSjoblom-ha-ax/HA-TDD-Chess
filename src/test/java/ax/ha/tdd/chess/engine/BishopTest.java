package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BishopTest {

    @Test
    public void testBishop() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("WHITE Bishop", new Bishop(PieceType.BISHOP, Player.WHITE, testCoords).toString());
    }

    @Test
    public void testBishopSymbol() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("BISHOP", new Bishop(PieceType.BISHOP, Player.WHITE, testCoords).getSymbol());
    }

    @Test
    public void testBishopMove() {
        Chessboard board = new Chessboard();
        String moveFrom = "c1";
        String moveTo= "f4";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);
        assertEquals(true, new Bishop(PieceType.BISHOP, Player.WHITE, testCoords).canMove(board, testCoords2));

        String moveTo2= "c4";
        Coordinates testCoords22 = new Coordinates(moveTo2);
        assertEquals(false, new Bishop(PieceType.KNIGHT, Player.WHITE, testCoords).canMove(board, testCoords22));

        //Try stepping on a tile with a friendly piece on
        String pieceBlock= "e3";
        Coordinates blockCoords = new Coordinates(pieceBlock);
        ChessPiece testPiece = new Bishop(PieceType.KNIGHT, Player.BLACK, blockCoords);
        board.addPiece(testPiece);
        assertEquals(false, new Bishop(PieceType.KNIGHT, Player.BLACK, testCoords).canMove(board, blockCoords));

        //Try stepping on a tile with a piece blocking
        assertEquals(false, new Rook(PieceType.ROOK, Player.BLACK, testCoords).canMove(board, testCoords2));

    }

}
