package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KingTest {

    @Test
    public void testKing() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("WHITE King", new King(PieceType.KING, Player.WHITE, testCoords).toString());
    }

    @Test
    public void testKingSymbol() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("KING", new King(PieceType.KING, Player.WHITE, testCoords).getSymbol());
    }

    @Test
    public void testKingMove() {
        Chessboard board = new Chessboard();
        String moveFrom = "d4";
        String moveTo= "e4";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);
        assertEquals(true, new King(PieceType.KING, Player.WHITE, testCoords).canMove(board, testCoords2));
    }

    @Test
    public void testKingIllegalMove() {
        Chessboard board = new Chessboard();
        String moveFrom = "d4";
        Coordinates testCoords = new Coordinates(moveFrom);

        String moveTo2= "f4";
        Coordinates testCoords22 = new Coordinates(moveTo2);
        assertEquals(false, new King(PieceType.KING, Player.WHITE, testCoords).canMove(board, testCoords22));

    }

    @Test
    public void testKingMoveOnPiece() {
        Chessboard board = new Chessboard();
        String moveFrom = "d4";
        String moveTo= "e4";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);

        ChessPiece testPiece = new King(PieceType.KNIGHT, Player.BLACK, testCoords2);
        board.addPiece(testPiece);
        assertEquals(false, new King(PieceType.KING, Player.BLACK, testCoords).canMove(board, testCoords2));

    }

}
