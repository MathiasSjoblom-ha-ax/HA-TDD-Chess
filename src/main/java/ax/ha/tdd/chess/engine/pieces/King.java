package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class King extends ChessPiece{

    public King(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return String.valueOf(PieceType.KING);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        Boolean moveable = true;
        Boolean notMoveable = false;

        if(destination == location) {
            return notMoveable;
        }

        ChessPiece pieceCheck = chessboard.getPiece(destination);
        if(pieceCheck != null && pieceCheck.getPlayer().getSymbol().equals(this.player.getSymbol())) {
            return notMoveable;
        }

        int x = location.getX();
        int y = location.getY();
        int destX = destination.getX();
        int destY = destination.getY();

        if((destX - x) < 2 && (destY - y) < 2) {
            return moveable;
        } else {
            return notMoveable;
        }
    }
}
