package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RookTest {

    @Test
    public void testRook() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("WHITE Rook", new Rook(PieceType.ROOK, Player.WHITE, testCoords).toString());
    }

    @Test
    public void testRookSymbol() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("ROOK", new Rook(PieceType.ROOK, Player.WHITE, testCoords).getSymbol());
    }

    @Test
    public void testRookMove() {
        Chessboard board = new Chessboard();
        String moveFrom = "a4";
        String moveTo= "h4";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);
        assertEquals(true, new Rook(PieceType.ROOK, Player.WHITE, testCoords).canMove(board, testCoords2));
    }

    @Test
    public void testRookIllegalMove() {
        Chessboard board = new Chessboard();
        String moveFrom = "a4";
        String moveTo= "h4";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);

        String moveTo2= "b3";
        Coordinates testCoords22 = new Coordinates(moveTo2);
        assertEquals(false, new Rook(PieceType.ROOK, Player.WHITE, testCoords).canMove(board, testCoords22));
    }

    @Test
    public void testRookMoveOnPiece() {
        Chessboard board = new Chessboard();
        String moveFrom = "a4";
        Coordinates testCoords = new Coordinates(moveFrom);

        String pieceBlock= "d4";
        Coordinates blockCoords = new Coordinates(pieceBlock);
        ChessPiece testPiece = new Rook(PieceType.ROOK, Player.BLACK, blockCoords);
        board.addPiece(testPiece);
        assertEquals(false, new Rook(PieceType.ROOK, Player.BLACK, testCoords).canMove(board, blockCoords));
    }

    @Test
    public void testRookMoveBlocked() {
        Chessboard board = new Chessboard();
        String moveFrom = "a4";
        String moveTo= "h4";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);

        String pieceBlock= "d4";
        Coordinates blockCoords = new Coordinates(pieceBlock);
        ChessPiece testPiece = new Rook(PieceType.ROOK, Player.BLACK, blockCoords);
        board.addPiece(testPiece);
        assertEquals(false, new Rook(PieceType.ROOK, Player.BLACK, testCoords).canMove(board, testCoords2));
    }
}
