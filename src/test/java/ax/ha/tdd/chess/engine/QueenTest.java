package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Queen;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {

    @Test
    public void testQueen() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("WHITE Queen", new Queen(PieceType.QUEEN, Player.WHITE, testCoords).toString());
    }

    @Test
    public void testRookSymbol() {
        String moveFrom = "d5";
        Coordinates testCoords = new Coordinates(moveFrom);
        assertEquals("QUEEN", new Queen(PieceType.QUEEN, Player.WHITE, testCoords).getSymbol());
    }

    @Test
    public void testQueenMove() {
        Chessboard board = new Chessboard();
        String moveFrom = "a4";
        String moveTo= "h4";
        Coordinates testCoords = new Coordinates(moveFrom);
        Coordinates testCoords2 = new Coordinates(moveTo);
        assertEquals(true, new Queen(PieceType.QUEEN, Player.WHITE, testCoords).canMove(board, testCoords2));

        //Try moving diagonaly
        String moveTo2= "d1";
        Coordinates testCoords22 = new Coordinates(moveTo2);
        assertEquals(true, new Queen(PieceType.QUEEN, Player.WHITE, testCoords).canMove(board, testCoords22));

        //Try stepping on a tile with a friendly piece on
        String pieceBlock= "d4";
        Coordinates blockCoords = new Coordinates(pieceBlock);
        ChessPiece testPiece = new Queen(PieceType.QUEEN, Player.BLACK, blockCoords);
        board.addPiece(testPiece);
        assertEquals(false, new Queen(PieceType.QUEEN, Player.BLACK, testCoords).canMove(board, blockCoords));

        //Try stepping on a tile with a piece blocking
        assertEquals(false, new Queen(PieceType.QUEEN, Player.BLACK, testCoords).canMove(board, testCoords2));
    }

}
