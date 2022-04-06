package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Knight extends ChessPiece{

    public Knight(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return String.valueOf(PieceType.KNIGHT);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        Boolean moveable = true;
        Boolean notMoveable = false;

        if(destination == location) {
            return notMoveable;
        }

        ChessPiece pieceCheck = chessboard.getPiece(destination);
        if(pieceCheck != null && pieceCheck.getPlayer().getSymbol() == this.player.getSymbol()) {
            return notMoveable;
        }

        int x = location.getX();
        int y = location.getY();
        int destX = destination.getX();
        int destY = destination.getY();

        if(destX == (x+2) && destY == (y+1)) {
            return moveable;
        }
        if(destX == (x+1) && destY == (y+2)) {
            return moveable;
        }
        if(destX == (x+2) && destY == (y-1)) {
            return moveable;
        }
        if(destX == (x+1) && destY == (y-2)) {
            return moveable;
        }

        if(destX == (x-2) && destY == (y+1)) {
            return moveable;
        }
        if(destX == (x-1) && destY == (y+2)) {
            return moveable;
        }
        if(destX == (x-2) && destY == (y-1)) {
            return moveable;
        }
        if(destX == (x-1) && destY == (y-2)) {
            return moveable;
        }

        return false;
    }
}
