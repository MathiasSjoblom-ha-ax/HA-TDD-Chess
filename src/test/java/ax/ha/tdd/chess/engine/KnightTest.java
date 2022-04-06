package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.PieceType;
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

}
