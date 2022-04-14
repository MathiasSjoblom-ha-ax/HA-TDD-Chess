package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void gameTestMove() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Game().move("2iu3b523ib5"));
        assertEquals("Illegal input", exception.getMessage());
    }

    @Test
    public void gameTestStateofGame() {
        Game game = new Game();
        assertEquals(Player.WHITE, new Game().getPlayerToMove());
        assertEquals(1, new Game().roundCounter());
    }
}
