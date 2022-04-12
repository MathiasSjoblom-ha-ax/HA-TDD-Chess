package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    public void testPawn() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("WHITE Pawn", new Pawn(PieceType.PAWN, Player.WHITE, testCoords).toString());
    }

    @Test
    public void testPawnSymbol() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("PAWN", new Pawn(PieceType.PAWN, Player.WHITE, testCoords).getSymbol());
    }

    @Test
    public void testPawnMove() {
        Chessboard board = new Chessboard();
        String moveFrom = "b2";
        String moveTo= "b3";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);
        assertEquals(true, new Pawn(PieceType.PAWN, Player.WHITE, testCoords).canMove(board, testCoords2));
    }

    @Test
    public void testPawnIllegalMove() {
        Chessboard board = new Chessboard();
        String moveFrom = "b2";
        Coordinates testCoords = new Coordinates(moveFrom);

        String moveTo2= "c3";
        Coordinates testCoords22 = new Coordinates(moveTo2);
        assertEquals(false, new Pawn(PieceType.PAWN, Player.WHITE, testCoords).canMove(board, testCoords22));

    }

    @Test
    public void testPawnMoveOnPiece() {
        Chessboard board = new Chessboard();
        String moveFrom = "b2";
        String moveTo= "b3";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);

        ChessPiece testPiece = new Pawn(PieceType.PAWN, Player.BLACK, testCoords2);
        board.addPiece(testPiece);
        assertEquals(false, new Pawn(PieceType.PAWN, Player.BLACK, testCoords).canMove(board, testCoords2));

    }


}
