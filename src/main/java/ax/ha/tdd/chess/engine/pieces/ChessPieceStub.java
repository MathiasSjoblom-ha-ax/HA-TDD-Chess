package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

/**
 *  Stub class in order to output a correct chessfield.
 *  This class should be deleted after implementations are done.
 */
public class ChessPieceStub extends ChessPiece {
    private final PieceType pieceType;

    public ChessPieceStub(final PieceType symbol, final Player player) {
        this(symbol, player, new Coordinates(0,0));
    }

    public ChessPieceStub(final PieceType symbol,
                          final Player player,
                          final Coordinates location) {
        super(symbol, player, location);
        this.pieceType = symbol;
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        return true;
    }
}
