package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void gameTestIllegalMove() {
        assertEquals(false, new Game().move("rgweg32f3f"));
    }

    @Test
    public void gameTestMove() {
        assertEquals(true, new Game().move("a2-a3"));
    }

    @Test
    public void gameTestStateofGame() {
        Game game = new Game();
        assertEquals(Player.WHITE, new Game().getPlayerToMove());
        assertEquals(1, new Game().roundCounter());
    }
}
